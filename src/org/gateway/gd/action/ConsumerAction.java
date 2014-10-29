package org.gateway.gd.action;

import org.gateway.gd.base.BaseAction;
import org.gateway.gd.domain.Consumer;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
@SuppressWarnings("serial")
public class ConsumerAction extends BaseAction<Consumer> {

	private int pageNum = 1;
	private int pageSize = 8;

	// ==========列表=====================
	public String list() throws Exception {
		QueryHelper queryHelper = new QueryHelper(Consumer.class, "c")
				.addOrderByProperty("id", true);
		PageBean pageBean = consumerService.getPageBean(pageNum, pageSize,
				queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean);

		return "list";
	}

	// ==========删除=====================
	public String delete() throws Exception {
		consumerService.delete(model.getId());
		return "toList";
	}

	// ==========添加页面=====================
	public String addUI() throws Exception {
		return "saveUI";
	}

	// ==========添加=====================
	public String add() throws Exception {
		consumerService.save(model);
		return "toList";
	}

	// ==========修改页面=====================
	public String editUI() throws Exception {
		Consumer consumer = consumerService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(consumer);
		return "saveUI";
	}

	// ==========修改=====================
	public String edit() throws Exception {
		// 1.从数据库中获取原对象
		Consumer consumer = consumerService.getById(model.getId());
		// 2.设置需要修改的属性值
		consumer.setName(model.getName());
		consumer.setContact(model.getContact());
		consumer.setPhoneNumber(model.getPhoneNumber());
		consumer.setAddress(model.getAddress());
		// 3.将修改保存到数据库
		consumerService.update(consumer);
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
