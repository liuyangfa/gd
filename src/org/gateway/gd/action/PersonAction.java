package org.gateway.gd.action;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
@SuppressWarnings("serial")
public class PersonAction extends BaseAction<User> {
	// ==============个人信息列表==============================
	public String list() throws Exception {
		// 获取当前登录用户的信息
		User userNow = (User) ActionContext.getContext().getSession()
				.get("user");
		User user = userService.getById(userNow.getId());
		ActionContext.getContext().put("user", user);
		return "list";
	}

	// ==============个人信息修改页面==============================
	public String editUI() throws Exception {
		// 准备回显的数据
		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		return "saveUI";
	}

	// ==============个人信息修改提交==============================
	public String edit() throws Exception {
		// 1.获取原对象
		User user = userService.getById(model.getId());
		// 2.设置要修改的属性
		user.setName(model.getName());
		user.setSex(model.getSex());
		user.setBirthday(model.getBirthday());
		user.setPhoneNumber(model.getPhoneNumber());
		user.setAddress(model.getAddress());
		user.setEmail(model.getEmail());
		// 3.更新到数据库
		userService.update(user);
		return "toList";
	}

}
