package org.gateway.gd.action;

import java.util.List;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.AbcAnalysis;
import org.gateway.gd.domain.BaseData;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class BaseDataAction extends BaseAction<Object> {

	private Long[] id;
	private String[] category; // 物料类别
	private Double[] yearStorage; // 年存储量
	private Double[] price; // 单价
	private Double[] yearAmountOfCapital; // 年资金占用额
	private int pageNum = 1;
	private int pageSize = 20;

	// ==========列表=====================
	public String list() throws Exception {
		QueryHelper queryHelper = new QueryHelper(BaseData.class, "b")//
				.addOrderByProperty("b.yearAmountOfCapital", false);
		PageBean pageBean = baseDataService.getPageBean(pageNum, pageSize,
				queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}

	// ==========删除=====================
	public String delete() throws Exception {
		List<BaseData> baseDatas = baseDataService.findAll();
		for (BaseData baseData : baseDatas) {
			baseDataService.delete(baseData.getId());
		}
		return "toList";
	}

	// ==========添加页面=====================
	public String addUI() throws Exception {
		System.out.println("jfaodj");
		return "saveUI";
	}

	// ==========添加=====================
	public String add() throws Exception {
		System.out.println(category.length);
		for (int i = 0; i < category.length; i++) {

			BaseData baseData = new BaseData();
			if (category[i] == null || yearStorage[i] == null
					|| yearAmountOfCapital[i] == null || price[i] == null) {
				continue;
			}
			baseData.setCategory(category[i]);
			baseData.setPrice(price[i]);
			baseData.setYearAmountOfCapital(yearAmountOfCapital[i]);
			baseData.setYearStorage(yearStorage[i]);

			baseDataService.save(baseData);
		}
		return "toList";
	}

	// ==========修改页面=====================
	public String editUI() throws Exception {
		List<BaseData> basedataList = baseDataService.findAll();
		ActionContext.getContext().put("basedataList", basedataList);
		return "saveUI";
	}

	// ==========修改=====================
	public String edit() throws Exception {
		int f = category.length;
		for (int i = 0; i < f; i++) {
			if (category == null || yearAmountOfCapital == null
					|| price == null || yearAmountOfCapital == null) {
				continue;
			}

			BaseData baseData = baseDataService.getById(id[i]);
			baseData.setId((long) i);
			baseData.setCategory(category[i]);
			baseData.setPrice(price[i]);
			baseData.setYearAmountOfCapital(yearAmountOfCapital[i]);
			baseData.setYearStorage(yearStorage[i]);
			baseDataService.update(baseData);
		}
		return "toList";
	}

	public String analysis() throws Exception {

		List<AbcAnalysis> abcAnalysisl = abcAnalysisService.findAll();
		if (abcAnalysisl.size() != 0) {
			for (AbcAnalysis abcAnalysis2 : abcAnalysisl) {
				abcAnalysisService.delete(abcAnalysis2.getId());
			}
		}
		List<BaseData> basedataList = baseDataService.findAll();

		// 品目数总计
		Double total = (double) basedataList.size();
		// 计算总的年资金占用额
		// Double totalYearAmountOfCapital = baseDataService.getTotalCapital();

		// 先保存物料名称，品目数累计，品目数累计百分比，单价，年库存量，年资金占用额
		for (BaseData bd : basedataList) {
			AbcAnalysis abcAnalysis = new AbcAnalysis();
			abcAnalysis.setYearAmountOfCapital(bd.getYearAmountOfCapital());
			abcAnalysis.setCategory(bd.getCategory());
			abcAnalysis.setId(bd.getId());
			abcAnalysis.setYearStorage(bd.getYearStorage());
			abcAnalysis.setPrice(bd.getPrice());
			abcAnalysis.setItemTotalPercent((bd.getId() * (1 / total) * 100));
			abcAnalysisService.save(abcAnalysis);
		}

		// 接下来计算每一条数据的年资金占用额累计
		Double yearTotal = 0.0;
		List<AbcAnalysis> abcAnalysisList = abcAnalysisService.findAll();
		for (AbcAnalysis abcAnalysis : abcAnalysisList) {
			abcAnalysis.setYearAmountOfCapitalTotal(abcAnalysis
					.getYearAmountOfCapital() + yearTotal);
			yearTotal = abcAnalysis.getYearAmountOfCapital() + yearTotal;
			abcAnalysisService.update(abcAnalysis);
		}

		// 年资金占用额累计百分比
		Double max = abcAnalysisService.getMax();
		List<AbcAnalysis> abcAnalysisLists = abcAnalysisService.findAll();
		for (AbcAnalysis abcAnalysis : abcAnalysisLists) {
			abcAnalysis.setYearAmountOfCapitalTotalPercent(abcAnalysis
					.getYearAmountOfCapitalTotal() / max * 100);
			abcAnalysisService.update(abcAnalysis);
		}

		// 分类
		List<AbcAnalysis> list = abcAnalysisService.findAll();
		for (AbcAnalysis abcAnalysis : list) {
			Double itemTotalPercent = abcAnalysis.getItemTotalPercent();
			Double yearAmountOfCapitalTotalPercent = abcAnalysis
					.getYearAmountOfCapitalTotalPercent();
			if ((itemTotalPercent > 0.0 && itemTotalPercent <= 20.0)
					&& (yearAmountOfCapitalTotalPercent > 0 && yearAmountOfCapitalTotalPercent <= 72)) {
				abcAnalysis.setClassification(AbcAnalysis.A);
				abcAnalysisService.update(abcAnalysis);
			} else if ((itemTotalPercent > 50.0 && itemTotalPercent <= 100.0)
					&& (yearAmountOfCapitalTotalPercent >= 80 && yearAmountOfCapitalTotalPercent <= 100)) {
				abcAnalysis.setClassification(AbcAnalysis.C);
				abcAnalysisService.update(abcAnalysis);
			} else {
				abcAnalysis.setClassification(AbcAnalysis.B);
				abcAnalysisService.update(abcAnalysis);
			}
		}

		return "toList";
	}

	public Long[] getId() {
		return id;
	}

	public void setId(Long[] id) {
		this.id = id;
	}

	public String[] getCategory() {
		return category;
	}

	public void setCategory(String[] category) {
		this.category = category;
	}

	public Double[] getYearStorage() {
		return yearStorage;
	}

	public void setYearStorage(Double[] yearStorage) {
		this.yearStorage = yearStorage;
	}

	public Double[] getPrice() {
		return price;
	}

	public void setPrice(Double[] price) {
		this.price = price;
	}

	public Double[] getYearAmountOfCapital() {
		return yearAmountOfCapital;
	}

	public void setYearAmountOfCapital(Double[] yearAmountOfCapital) {
		this.yearAmountOfCapital = yearAmountOfCapital;
	}

}
