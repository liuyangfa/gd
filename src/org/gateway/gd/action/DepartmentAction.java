package org.gateway.gd.action;

import java.util.List;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.Department;
import org.gateway.gd.util.DepartmentUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {

	private Long parentId;

	// ==========列表=====================
	public String list() throws Exception {
		List<Department> departmentList = departmentService.findAll();

		if (parentId == null) {// 查询所有的顶级部门
			departmentList = departmentService.findTopList();
		} else {// 查询指定部门的子部门列表
			departmentList = departmentService.findChildren(parentId);
			// 查询上级部门信息
			Department parent = departmentService.getById(parentId);
			ActionContext.getContext().put("parent", parent);
		}

		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}

	// ==========删除:同时删除此部门的所有下级部门=====================
	public String delete() throws Exception {
		departmentService.delete(model.getId());
		return "toList";
	}

	// ==========添加页面=====================
	public String addUI() throws Exception {
		// 准备部门列表:部门列表，应显示为树状结构
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils
				.getAllDepartmentList(topList);
		ActionContext.getContext().put("departmentList", departmentList);

		return "saveUI";
	}

	// ==========添加=====================
	public String add() throws Exception {
		// 新建对象并设置属性
		model.setParent(departmentService.getById(parentId));
		// 保存
		departmentService.save(model);
		return "toList";
	}

	// ==========修改页面=====================
	public String editUI() throws Exception {

		// 准备回显数据
		Department department = departmentService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(department);
		if (department.getParent() != null) {
			parentId = department.getParent().getId();
		}

		// 准备部门列表:部门列表，应显示为树状结构
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils
				.getAllDepartmentList(topList);
		DepartmentUtils.removeParentAndChildren(departmentList,department);//从集合中移除指定部门及下级部门
		ActionContext.getContext().put("departmentList", departmentList);

		return "saveUI";
	}

	// ==========修改=====================
	public String edit() throws Exception {
		// 获取源对象
		Department department = departmentService.getById(model.getId());

		// 设置要修改的属性
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		department.setParent(departmentService.getById(parentId));
		;
		// 更新
		departmentService.update(department);

		return "toList";
	}

	// ============setter and getter method=======================
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
