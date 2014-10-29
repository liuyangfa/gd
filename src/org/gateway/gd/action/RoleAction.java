package org.gateway.gd.action;

import java.util.List;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.Privilege;
import org.gateway.gd.domain.Role;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

	private int pageNum = 1;
	private int pageSize = 9;
	private Long[] privilegeIds;

	// ==========列表=====================
	public String list() throws Exception {

		QueryHelper queryHelper = new QueryHelper(Role.class, "r")
				.addOrderByProperty("id", true);
		PageBean pageBean = roleService.getPageBean(pageNum, pageSize,
				queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean);

		return "list";
	}

	// ==========删除=====================
	public String delete() throws Exception {
		roleService.delete(model.getId());
		return "toList";
	}

	// ==========添加页面=====================
	public String addUI() throws Exception {
		return "saveUI";
	}

	// ==========添加=====================
	public String add() throws Exception {
		roleService.save(model);
		return "toList";
	}

	// ==========修改页面=====================
	public String editUI() throws Exception {
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}

	// ==========修改=====================
	public String edit() throws Exception {
		// 1.从数据库中获取原对象
		Role role = roleService.getById(model.getId());
		// 2.设置需要修改的属性值
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		// 3.将修改保存到数据库
		roleService.update(role);
		return "toList";
	}

	// ==========设置权限页面=====================
	public String setPrivilegeUI() throws Exception {
		// 准备数据：岗位信息
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);

		// 准备数据：权限列表，树状结构显示
		List<Privilege> topPrivilegeList = privilegeService.findTopList();
		ActionContext.getContext().put("topPrivilegeList", topPrivilegeList);

		// 准备回显的数据
		privilegeIds = new Long[role.getPrivileges().size()];
		int index = 0;
		for (Privilege privilege : role.getPrivileges()) {
			privilegeIds[index++] = privilege.getId();
		}

		return "setPrivilegeUI";
	}

	// ==========设置权限=====================
	public String setPrivilege() throws Exception {
		// 1.从数据库中获取原对象
		Role role = roleService.getById(model.getId());
		// 2.设置需要修改的属性值
		role.setPrivileges(privilegeService.getByIds(privilegeIds));
		// 3.将修改保存到数据库
		roleService.update(role);
		return "toList";
	}

	// ======================================================
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
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
