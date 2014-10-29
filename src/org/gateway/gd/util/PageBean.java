package org.gateway.gd.util;

import java.util.List;

/**
 * @项目名称 ： GraduationDesign
 * @类名称 ： PageBean
 * @类描述 ： 分页功能中的一页的信息
 * @创建人 ： gateway
 * @创建时间 ： 2014-7-4 上午10:38:54
 * @修改人 ： gateway
 * @修改时间 ： 2014-7-4 上午10:38:54
 */
@SuppressWarnings("rawtypes")
public class PageBean {

	// 此块变量是通过查询数据库获取的
	private int recordCount; // 总记录数
	private List recordList; // 本页的数据列表

	// 此块变量是通过指定的或页面参数获取的
	private int currentPage; // 当前页
	private int pageSize; // 每页显示多少条数据

	// 此块变量是通过计算得到的
	private int pageCount; // 总页数
	private int beginPageIndex; // 页码列表的开始索引
	private int endPageIndex; // 页码列表的结束索引

	/**
	 * 只接收前四个必要属性的值，会自动计算出其他三个属性的值
	 * 
	 */
	public PageBean(int currentPage, int pageSize, int recordCount,
			List recordList) {
		super();
		this.recordCount = recordCount;
		this.recordList = recordList;
		this.currentPage = currentPage;
		this.pageSize = pageSize;

		// 计算总页码
		pageCount = (recordCount + pageSize - 1) / pageSize;

		// 计算页码列表的beginPageIndex endPageIndex
		// 总页数不多于10页，则全部显示
		if (pageCount <= 10) {
			beginPageIndex = 1;
			endPageIndex = pageCount; 
		} else {
			// 总页数多于10页，则显示当前页附近的10个页码
			// 当前页附近的共10个页码（前四个，当前页，后五个）
			beginPageIndex = currentPage - 4;
			endPageIndex = currentPage + 5;
			if (beginPageIndex < 1) {
				// 当前面页码不足4个时，则显示前10个页码
				beginPageIndex = 1;
				endPageIndex = 10;
			} 
			if (endPageIndex > pageCount) {
				// 当后面页码不足5个时，则显示后10个页码
				endPageIndex = pageCount;
				beginPageIndex = pageCount - 10 + 1;
			}
		}
	}

	public List getRecordList() {
		return recordList;
	}

	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getBeginPageIndex() {
		return beginPageIndex;
	}

	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
}
