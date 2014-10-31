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
	private Object data;

	/**
	 * 获取所有记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		List<AbcAnalysis> abcAnalysisList = abcAnalysisService.findAll();
		ActionContext.getContext().put("abcAnalysisList", abcAnalysisList);

		return "list";
	}

	/**
	 * ABC分类图
	 * 
	 * @return
	 * @throws Exception
	 */
	public String labelLine() throws Exception {

		List<AbcAnalysis> abcAnalysisList = abcAnalysisService.findAll();
		data = abcAnalysisList;

		return "json";
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
