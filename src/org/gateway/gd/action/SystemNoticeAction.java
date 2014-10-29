package org.gateway.gd.action;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.SystemNotice;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
@SuppressWarnings("serial")
public class SystemNoticeAction extends BaseAction<SystemNotice> {

	private int pageNum = 1;
	private int pageSize = 8;

	// 通知列表
	public String list() throws Exception {
		QueryHelper queryHelper = new QueryHelper(SystemNotice.class, "alm")
				.addOrderByProperty("id", false);
		PageBean pageBean = systemNoticeService.getPageBean(pageNum, pageSize,
				queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}

	// 通知详情
	public String listInfo() throws Exception {
		
		SystemNotice systemNotice = systemNoticeService.getById(model.getId());
		systemNotice.setViewyn(SystemNotice.VIEWY);
		systemNoticeService.save(systemNotice);
		ActionContext.getContext().put("systemNotice", systemNotice);;
		return "listInfo";
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
