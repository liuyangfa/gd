package org.gateway.gd.action;

import java.util.List;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.Position;
import org.gateway.gd.domain.Warehouse;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class PositionAction extends BaseAction<Position> {

	private Long warehouseId;

	// ==========列表=====================
	public String list() throws Exception {
		List<Position> positionList = positionService.findAll();
		ActionContext.getContext().put("positionList", positionList);
		return "list";
	}

	// ==========删除=====================
	public String delete() throws Exception {
		positionService.delete(model.getId());
		return "toList";
	}

	// ==========添加页面=====================
	public String addUI() throws Exception {
		// 准备仓库列表：warehouse
		List<Warehouse> warehouseList = warehouseService.findAll();
		ActionContext.getContext().put("warehouseList", warehouseList);
		return "saveUI";
	}

	// ==========添加=====================
	public String add() throws Exception {
		model.setWarehouse(warehouseService.getById(warehouseId));
		positionService.save(model);
		return "toList";
	}

	// ==========修改页面=====================
	public String editUI() throws Exception {
		// 准备仓库列表：warehouse
		List<Warehouse> warehouseList = warehouseService.findAll();
		ActionContext.getContext().put("warehouseList", warehouseList);

		Position position = positionService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(position);

		if (position.getWarehouse() != null) {
			warehouseId = position.getWarehouse().getId();
		}
		return "saveUI";
	}

	// ==========修改=====================
	public String edit() throws Exception {
		// 1.获取原对象
		Position position = positionService.getById(model.getId());
		// 2.设置要修改的属性
		position.setName(model.getName());
		position.setDescription(model.getDescription());
		position.setWarehouse(warehouseService.getById(warehouseId));
		// 3.更新到数据库
		positionService.update(position);
		return "toList";
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

}
