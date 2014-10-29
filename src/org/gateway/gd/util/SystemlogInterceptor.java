package org.gateway.gd.util;

import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.gateway.gd.domain.Systemlog;
import org.gateway.gd.domain.User;
import org.gateway.gd.service.PrivilegeService;
import org.gateway.gd.service.SystemLogService;
import org.gateway.gd.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.config.entities.ExceptionMappingConfig;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("serial")
public class SystemlogInterceptor extends MethodFilterInterceptor {

	@Resource
	private SystemLogService systemLogService = null;
	@Resource
	private PrivilegeService privilegeService = null;
	@Resource
	private UserService userService;

	/*
	 * 日志要实现的业务逻辑
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		String result = invocation.invoke();
		List<ExceptionMappingConfig> exceptionMappings = invocation.getProxy()
				.getConfig().getExceptionMappings();
		for (ExceptionMappingConfig temp : exceptionMappings) {
			if (temp.getResult().equals(result)) {
				// 说明出现异常
				return result;
			}
		}
		// 1: 获取systemLogServiceImpl业务逻辑类
		// 获取application内置对象
		ServletContext sc = (ServletContext) invocation.getInvocationContext()
				.get(StrutsStatics.SERVLET_CONTEXT);
		// 获取Spring配置文件
		ApplicationContext context = (ApplicationContext) WebApplicationContextUtils
				.getWebApplicationContext(sc);
		// 获取logsServiceImpl
		systemLogService = (SystemLogService) context
				.getBean("systemLogServiceImpl");
		// 2: 获取所有的参数信息
		Systemlog systemlog = new Systemlog();
		HttpServletRequest request = (HttpServletRequest) invocation
				.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
		// 获取所有的参数名称
		Enumeration<String> parmEnum = request.getParameterNames();
		StringBuffer buffer = new StringBuffer();
		while (parmEnum.hasMoreElements()) {
			// 通过当前名称获取当前的值 sname:admin,spass:***,
			String paramName = parmEnum.nextElement();
			// 追加参数名
			buffer.append(paramName);
			buffer.append("是");
			for (String temp : request.getParameterValues(paramName)) {
				buffer.append(temp);
				buffer.append("、");
			}
			buffer.deleteCharAt(buffer.length() - 1);
			buffer.append(",");
		}
		// 注入系统当前时间
		Date now = new Date();
		DateFormat date = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.FULL);
		String nowdate = date.format(now);
		systemlog.setDate(nowdate);

		systemlog.setHost(request.getLocalName());

		// 获取真实的ip地址
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		systemlog.setIpAddr(ip);

		// 添加当前操作的用户
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			systemlog.setUser(user);
		} else {
			System.out.println(request.getSession().getAttribute("u"));
			User user2 = userService.getById((Long) request.getSession()
					.getAttribute("u"));
			systemlog.setUser(user2);
		}

		// 获取当前用户所做的操作
		String path = request.getServletPath();
		int pos = path.indexOf(".");
		if (pos > -1) {
			path = path.substring(0, pos); // 去掉参数
		}
		if (path.startsWith("/")) {
			path = path.substring(1);
		}

		String url = privilegeService.getByPath(path);
		if (url != null) {
			path = url;
		}
		if (path.equals("loginLogoutAction_login")) {
			path = user.getName() + "登录";
		}
		if (path.equals("loginLogoutAction_logout")) {
			path = userService.getById(
					(Long) request.getSession().getAttribute("u")).getName()
					+ "退出登录";
		}
		System.out.println(path);
		if (path.equals("personAction_edit")) {
			path = "个人信息修改";
		}
		if (path.equals("passwordAction_edit")) {
			path = "密码修改";
		}
		systemlog.setPath(path);// 拿到当前请求的action

		// 获取连接好的参数
		System.out.println(buffer.length());
		if (buffer.length() != 0) {
			systemlog.setParam(buffer.deleteCharAt(buffer.length() - 1)
					.toString());
		}
		// 3: 日志入库,并且跳转到下一个拦截器
		systemLogService.save(systemlog);

		return result;
	}
}
