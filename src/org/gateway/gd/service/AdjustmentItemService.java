package org.gateway.gd.service;

import org.gateway.gd.domain.AdjustmentItem;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;

public interface AdjustmentItemService {

	AdjustmentItem getById(Long id);

	void delete(Long id);

	void save(AdjustmentItem adjustmentItem);

	void update(AdjustmentItem adjustmentItem);

	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);


}
