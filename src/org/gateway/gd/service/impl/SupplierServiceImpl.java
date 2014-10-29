package org.gateway.gd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.gateway.gd.dao.SupplierDao;
import org.gateway.gd.domain.Supplier;
import org.gateway.gd.service.SupplierService;
import org.gateway.gd.util.PageBean;
import org.gateway.gd.util.QueryHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

	@Resource
	private SupplierDao supplierDao;

	public void delete(Long id) {
		supplierDao.delete(id);

	}

	public List<Supplier> findAll() {
		return supplierDao.findAll();
	}

	public void save(Supplier supplier) {
		supplierDao.save(supplier);
	}

	public Supplier getById(Long id) {
		return supplierDao.getById(id);
	}

	public void update(Supplier supplier) {
		supplierDao.update(supplier);
	}

	public PageBean getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		return supplierDao.getPageBean(pageNum, pageSize, queryHelper);
	}

}
