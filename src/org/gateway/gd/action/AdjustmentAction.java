package org.gateway.gd.action;

import java.util.Date;
import java.util.List;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.AdjustmentItem;
import org.gateway.gd.domain.AdjustmentMaterials;
import org.gateway.gd.domain.Materials;
import org.gateway.gd.domain.User;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

/**
 * 库存调整
 * 
 * @author gateway
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class AdjustmentAction extends BaseAction<Object> {

	private Long id;
	private Date date; // 调整时间
	private String checker;
	private String checkyn;
	private String description;
	private Long userId;

	private Long[] materialsId;
	private Double[] number; // 账存数量
	private Double[] realNumber; // 实存数量
	private Double[] adjustNumber; // 调整数量
	private Double[] differenceQuantity;// 差异量
	private String[] differenceReason; // 差异原因
	private String[] adjustReason; // 调整原因

	private int pageNum = 1;
	private int pageSize = 8;

	// ==========列表=====================
	public String list() throws Exception {
		QueryHelper queryHelper = new QueryHelper(AdjustmentItem.class, "ai")//
				.addOrderByProperty("date", false);
		PageBean pageBean = adjustmentItemService.getPageBean(pageNum,
				pageSize, queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean);

		return "list";
	}

	// ==========删除=====================
	public String delete() throws Exception {
		// 单据未审核就可以删除，否则不能删除
		if (adjustmentItemService.getById(id).getCheckyn().equals("未审核")) {
			adjustmentItemService.delete(id);
		}
		return "toList";
	}

	// =============调整单详细情况=======================
	public String listInfo() throws Exception {

		// 该盘点单的详细情况
		List<AdjustmentMaterials> adjustmentMaterials = adjustmentMaterialsService
				.getByListId(id);
		ActionContext.getContext().put("adjustmentMaterials",
				adjustmentMaterials);

		return "listInfo";
	}

	// ==========修改页面=====================
	public String editUI() throws Exception {

		// 用户列表
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);

		// 物料列表
		List<Materials> materialsList = materialsService.findAll();
		ActionContext.getContext().put("materialsList", materialsList);

		AdjustmentItem adjustmentItem = adjustmentItemService.getById(id);
		ActionContext.getContext().getValueStack().push(adjustmentItem);

		List<AdjustmentMaterials> adjustmentMaterialsList = adjustmentMaterialsService
				.getByListId(id);
		ActionContext.getContext().put("adjustmentMaterialsList",
				adjustmentMaterialsList);

		if (adjustmentItem.getUser() != null) {
			userId = adjustmentItem.getUser().getId();
		}

		return "saveUI";
	}

	// ==========修改=====================
	public String edit() throws Exception {

		AdjustmentItem adjustmentItem = adjustmentItemService.getById(id);
		adjustmentItem.setDate(date);
		adjustmentItem.setDescription(description);
		adjustmentItem.setUser(userService.getById(userId));
		adjustmentItemService.save(adjustmentItem);

		for (int i = 0; i < materialsId.length; i++) {
			AdjustmentMaterials adjustmentMaterials = adjustmentMaterialsService
					.getByMaterialsId(materialsId[i]);
			adjustmentMaterials.setDifferenceQuantity(differenceQuantity[i]);
			adjustmentMaterials.setDifferenceReason(differenceReason[i]);
			adjustmentMaterials.setAdjustReason(adjustReason[i]);
			adjustmentMaterials.setAdjustNumber(adjustNumber[i]);
			adjustmentMaterialsService.update(adjustmentMaterials);
		}

		return "toList";
	}

	// ===============审核=======================
	public String audit() throws Exception {
		// 获取要审核的入库单信息

		AdjustmentItem adjustmentItem = adjustmentItemService.getById(id);
		// 审核入库单
		if (adjustmentItem.getCheckyn().equals("未审核")) {
			adjustmentItem.setCheckyn(AdjustmentItem.CHECKY);
			adjustmentItem.setChecker(BaseAction.getCurrentUser().getName()); // 记录入库单的审核人
			adjustmentItemService.update(adjustmentItem);
		}
		return "toList";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public String getCheckyn() {
		return checkyn;
	}

	public void setCheckyn(String checkyn) {
		this.checkyn = checkyn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long[] getMaterialsId() {
		return materialsId;
	}

	public void setMaterialsId(Long[] materialsId) {
		this.materialsId = materialsId;
	}

	public Double[] getNumber() {
		return number;
	}

	public void setNumber(Double[] number) {
		this.number = number;
	}

	public Double[] getRealNumber() {
		return realNumber;
	}

	public void setRealNumber(Double[] realNumber) {
		this.realNumber = realNumber;
	}

	public Double[] getAdjustNumber() {
		return adjustNumber;
	}

	public void setAdjustNumber(Double[] adjustNumber) {
		this.adjustNumber = adjustNumber;
	}

	public Double[] getDifferenceQuantity() {
		return differenceQuantity;
	}

	public void setDifferenceQuantity(Double[] differenceQuantity) {
		this.differenceQuantity = differenceQuantity;
	}

	public String[] getDifferenceReason() {
		return differenceReason;
	}

	public void setDifferenceReason(String[] differenceReason) {
		this.differenceReason = differenceReason;
	}

	public String[] getAdjustReason() {
		return adjustReason;
	}

	public void setAdjustReason(String[] adjustReason) {
		this.adjustReason = adjustReason;
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
