package org.gateway.gd.action;

import java.util.List;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.Department;
import org.gateway.gd.domain.Role;
import org.gateway.gd.domain.User;
import org.gateway.gd.util.DepartmentUtils;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	private int pageNum = 1;
	private int pageSize = 9;
	private Long departmentId;
	private Long[] roleIds;

	// ==========列表=====================
	public String list() throws Exception {
		// 如果有超级管理员，就将他从列表中移除
		// User admin = userService.getByLoginNameAndPassword("admin", "admin");
		// List<User> userList = userService.findAll();
		// userList.remove(admin);
		// ActionContext.getContext().put("userList", userList);

		QueryHelper queryHelper = new QueryHelper(User.class, "us");
		PageBean pageBean = userService.getPageBean(pageNum, pageSize,
				queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean);

		return "list";
	}

	// ==========删除=====================
	public String delete() throws Exception {
		userService.delete(model.getId());
		return "toList";
	}

	// ==========添加页面=====================
	public String addUI() throws Exception {
		// 准备部门列表:部门列表，应显示为树状结构
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils
				.getAllDepartmentList(topList);
		ActionContext.getContext().put("departmentList", departmentList);

		// 准备岗位列表
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "saveUI";
	}

	// ==========添加=====================
	public String add() throws Exception {
		// 1.新建对象并设置属性
		model.setDepartment(departmentService.getById(departmentId));
		model.setRoles(roleService.getByIds(roleIds));
		// 2.保存
		userService.save(model);
		return "toList";
	}

	// ==========修改页面=====================
	public String editUI() throws Exception {
		// 准备部门列表:部门列表，应显示为树状结构
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils
				.getAllDepartmentList(topList);
		ActionContext.getContext().put("departmentList", departmentList);

		// 准备岗位列表
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);

		// 准备回显的数据
		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		if (user.getDepartment() != null) {
			departmentId = user.getDepartment().getId();
		}
		if (user.getRoles() != null) {
			roleIds = new Long[user.getRoles().size()];
			int index = 0;
			for (Role role : user.getRoles()) {
				roleIds[index++] = role.getId();
			}
		}

		return "saveUI";
	}

	// ==========修改=====================
	public String edit() throws Exception {
		// 1.获取原对象
		User user = userService.getById(model.getId());
		// 2.设置要修改的属性
		user.setName(model.getName());
		user.setLoginName(model.getLoginName());
		user.setSex(model.getSex());
		user.setBirthday(model.getBirthday());
		user.setEmail(model.getEmail());
		user.setPhoneNumber(model.getPhoneNumber());
		user.setAddress(model.getAddress());
		user.setDescription(model.getDescription());

		user.setDepartment(departmentService.getById(departmentId));
		user.setRoles(roleService.getByIds(roleIds));
		// 3.更新到数据库
		userService.update(user);
		return "toList";
	}

	// ==========初始化密码==================================
	public String initPassword() throws Exception {
		userService.initPassword(model.getId());
		return "toList";
	}

	// ========setter and getter method====================
	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
