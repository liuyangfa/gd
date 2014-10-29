package org.gateway.gd.util;

import org.gateway.gd.action.LoginLogoutAction;
import org.gateway.gd.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
	
		//获取当前登录用户
		User user=(User) ActionContext.getContext().getSession().get("user");
		//获取当前访问的URL(action),处理后缀
		String url=invocation.getProxy().getActionName();
		if(url.endsWith("UI")){
			url=url.substring(0,url.length()-2);
		}
		
		//未登录
		if(user==null){
			
			if(invocation.getProxy().getAction() instanceof LoginLogoutAction){//如果正在使用登录功能，放行
				return invocation.invoke();//放行
			}else{//没有使用登录功能，转到登录页面
				return "loginUI";
			}
		}
		//已登录
		else{
			if(user.hasPrivilegeByUrl(url)){//如果有权限，放行
				return invocation.invoke();//放行
			}else{//如果没权限，转到错误页面
				return "privilegeError";
			}
		}
	}

}
