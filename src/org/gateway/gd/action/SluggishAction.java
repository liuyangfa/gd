package org.gateway.gd.action;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.SluggishMaterials;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
@SuppressWarnings("serial")
public class SluggishAction extends BaseAction<SluggishMaterials> {

	private int pageNum = 1;
	private int pageSize = 10;

	// ==========列表=====================
	public String list() throws Exception {
		QueryHelper queryHelper = new QueryHelper(SluggishMaterials.class, "s")
				.addOrderByProperty("s.id", true);
		PageBean pageBean = sluggishMaterialsService.getPageBean(pageNum,
				pageSize, queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}

	// ==========删除=====================
	public String delete() throws Exception {
		sluggishMaterialsService.delete(model.getId());
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
