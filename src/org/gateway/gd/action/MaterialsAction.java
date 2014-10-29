package org.gateway.gd.action;

import java.util.List;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.Category;
import org.gateway.gd.domain.Materials;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class MaterialsAction extends BaseAction<Materials> {

	private int pageNum = 1;
	private int pageSize = 8;
	private Long categoryId;

	// ==========列表=====================
	public String list() throws Exception {
		QueryHelper queryHelper = new QueryHelper(Materials.class, "m")
				.addOrderByProperty("id", true);
		PageBean pageBean = materialsService.getPageBean(pageNum, pageSize,
				queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean);

		// List<Materials> materialsList = materialsService.findAll();
		// ActionContext.getContext().put("materialsList", materialsList);
		return "list";
	}

	// ==========删除=====================
	public String delete() throws Exception {
		materialsService.delete(model.getId());
		return "toList";
	}

	// ==========添加页面=====================
	public String addUI() throws Exception {
		List<Category> categoryList = categoryService.findAll();
		ActionContext.getContext().put("categoryList", categoryList);

		return "saveUI";
	}

	// ==========添加=====================
	public String add() throws Exception {
		model.setCategory(categoryService.getById(categoryId));
		materialsService.save(model);
		return "toList";
	}

	// ==========修改页面=====================
	public String editUI() throws Exception {
		List<Category> categoryList = categoryService.findAll();
		ActionContext.getContext().put("categoryList", categoryList);

		Materials materials = materialsService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(materials);

		if (materials.getCategory() != null) {
			categoryId = materials.getCategory().getId();
		}
		return "saveUI";
	}

	// ==========修改=====================
	public String edit() throws Exception {
		Materials materials = materialsService.getById(model.getId());
		materials.setCategory(categoryService.getById(categoryId));
		materials.setName(model.getName());
		materials.setSpecifications(model.getSpecifications());
		materials.setDescription(model.getDescription());
		materials.setLowestInventory(model.getLowestInventory());
		materials.setHighestInventory(model.getHighestInventory());
		materials.setSafeInventory(model.getSafeInventory());
		materials.setNoAmountOfTime(model.getNoAmountOfTime());

		materialsService.update(materials);
		return "toList";
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
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