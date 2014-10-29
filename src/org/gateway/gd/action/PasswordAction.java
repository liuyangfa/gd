package org.gateway.gd.action;

import org.apache.struts2.ServletActionContext;
import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
@SuppressWarnings("serial")
public class PasswordAction extends BaseAction<User> {
	// ==============个人登录密码修改页面===========================
	public String list() throws Exception {
		return "list";
	}

	public void validateEdit() {
		User userNow = (User) ActionContext.getContext().getSession()
				.get("user");
		User user = userService.getById(userNow.getId());
		String password = user.getPassword();
		String oldpwd = DigestUtils.md5DigestAsHex(ServletActionContext
				.getRequest().getParameter("oldpassword").getBytes());
		if (!password.equals(oldpwd)) {
			addFieldError("oldpassword", "旧密码不正确!");
		}
		if (!ServletActionContext
				.getRequest()
				.getParameter("newpassword")
				.equals(ServletActionContext.getRequest().getParameter(
						"confirmpassword"))) {
			addFieldError("newpassword", "两次输入的密码不一致");
		}
	}

	// ==============个人登录密码修改提交===========================
	@SuppressWarnings("static-access")
	public String edit() throws Exception {
		// 获取当前登录用户的信息
		User userNow = (User) ActionContext.getContext().getSession()
				.get("user");
		User user = userService.getById(userNow.getId());
//		String password = user.getPassword();
//		String oldpwd = DigestUtils.md5DigestAsHex(ServletActionContext
//				.getRequest().getParameter("oldpassword").getBytes());
//		System.out.println(password);
//		System.out.println(oldpwd);
		user.setPassword(DigestUtils.md5DigestAsHex(ServletActionContext
				.getRequest().getParameter("newpassword").getBytes()));
		userService.update(user);
		return this.SUCCESS;

	}
}
