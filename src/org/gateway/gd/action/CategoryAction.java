package org.gateway.gd.action;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.Category;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class CategoryAction extends BaseAction<Category> {

	private int pageNum = 1;
	private int pageSize = 10;

	// ==========列表=====================
	public String list() throws Exception {
		QueryHelper queryHelper = new QueryHelper(Category.class, "ca")
				.addOrderByProperty("id", true);
		PageBean pageBean = categoryService.getPageBean(pageNum, pageSize,
				queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}

	// ==========删除=====================
	public String delete() throws Exception {
		categoryService.delete(model.getId());
		return "toList";
	}

	// ==========添加页面=====================
	public String addUI() throws Exception {
		return "saveUI";
	}

	// ==========添加=====================
	public String add() throws Exception {
		categoryService.save(model);
		return "toList";
	}

	// ==========修改页面=====================
	public String editUI() throws Exception {
		Category category = categoryService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(category);
		return "saveUI";
	}

	// ==========修改=====================
	public String edit() throws Exception {
		Category category = categoryService.getById(model.getId());
		category.setName(model.getName());
		category.setDescription(model.getDescription());
		categoryService.update(category);
		return "toList";
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
