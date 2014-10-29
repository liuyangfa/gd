package org.gateway.gd.action;

import java.util.List;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.AbcAnalysis;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
@SuppressWarnings("serial")
public class AbcAnalysisAction extends BaseAction<AbcAnalysis> {
	// ==========列表=====================
	public String list() throws Exception {
		List<AbcAnalysis> abcAnalysisList = abcAnalysisService.findAll();
		ActionContext.getContext().put("abcAnalysisList", abcAnalysisList);
		return "list";
	}

	// ==========删除=====================
	public String delete() throws Exception {
		departmentService.delete(model.getId());
		return "toList";
	}

	// ==========添加页面=====================
	public String addUI() throws Exception {

		return "saveUI";
	}

	// ==========添加=====================
	public String add() throws Exception {
		return "toList";
	}

	// ==========修改页面=====================
	public String editUI() throws Exception {
		return "saveUI";
	}

	// ==========修改=====================
	public String edit() throws Exception {
		return "toList";
	}
}
