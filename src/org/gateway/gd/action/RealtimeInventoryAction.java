package org.gateway.gd.action;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.RealtimeInventory;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class RealtimeInventoryAction extends BaseAction<RealtimeInventory> {

	private int pageNum = 1;
	private int pageSize = 8;

	// ==========列表=====================
	public String list() throws Exception {
		QueryHelper queryHelper = new QueryHelper(RealtimeInventory.class, "r");
		PageBean pageBean = realtimeInventoryService.getPageBean(pageNum,
				pageSize, queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
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
