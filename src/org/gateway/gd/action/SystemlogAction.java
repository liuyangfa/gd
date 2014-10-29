package org.gateway.gd.action;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.Systemlog;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
@SuppressWarnings("serial")
public class SystemlogAction extends BaseAction<Systemlog> {

	private int pageNum = 1;
	private int pageSize = 9;

	// 列表
	public String list() throws Exception {

		QueryHelper queryHelper = new QueryHelper(Systemlog.class, "s").addOrderByProperty("date", false);
		
		if(!BaseAction.getCurrentUser().getName().equals("超级管理员")){
			queryHelper.addWhereCondition("s.user.id=?", BaseAction.getCurrentUser().getId());
		}
		PageBean pageBean = systemLogService.getPageBean(pageNum, pageSize,
				queryHelper);
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
