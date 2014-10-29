package org.gateway.gd.action;

import java.util.Collection;
import java.util.List;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.Privilege;
import org.gateway.gd.domain.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
@SuppressWarnings("serial")
public class LoginLogoutAction extends BaseAction<User> {

	// 登陆页面
	public String loginUI() throws Exception {
		return "loginUI";
	}

	// 登陆
	public String login() throws Exception {

		User user = userService.getByLoginNameAndPassword(model.getLoginName(),
				model.getPassword());
		if (user == null) {
			addFieldError("login", "用户名或密码不正确!");
			return "loginUI";
		} else {
			ActionContext.getContext().getSession().put("user", user);
			// 准备菜单列表数据
			List<Privilege> topMenuList = privilegeService.findTopList();
			ActionContext.getContext().getApplication()
					.put("topMenuList", topMenuList);

			// 将所有权限的URL列表放入application中
			Collection<String> allPrivilegeUrls = privilegeService
					.getAllPrivilegeUrls();
			ActionContext.getContext().getApplication()
					.put("allPrivilegeUrls", allPrivilegeUrls);

			return "toIndex";
		}
	}

	// 注销
	public String logout() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		Long u = user.getId();
		ActionContext.getContext().getSession().put("u", u);
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}
}