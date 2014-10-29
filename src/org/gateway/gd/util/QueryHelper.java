package org.gateway.gd.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @项目名称 ：GraduationDesign
 * @类名称 ： QueryHelper
 * @类描述 ： 用于辅助拼接HQL子句
 * @创建人 ：gateway
 * @创建时间 ： 2014-7-5 上午09:56:30
 * @修改人 ： gateway
 */

public class QueryHelper {
	
	/**
	 * fromClause： FROM子句
	 */
	private StringBuffer	fromClause		= null;
	
	/**
	 * whereClause：WHERE子句
	 */
	private StringBuffer	whereClause		= null;
	
	/**
	 * orderByClause： ORDER BY 子句
	 */
	private StringBuffer	orderByClause	= null;
	
	private List<Object>	parameters		= new ArrayList<Object>();
	
	/**
	 * 生成FROM子句
	 * 
	 * @param :查询对象
	 * @param :别名
	 */
	public QueryHelper(Class<?> clazz, String alias) {
		fromClause = new StringBuffer(" FROM " + clazz.getSimpleName() + " " + alias);
	}
	
	/**
	 * 拼接WHERE子句
	 * 
	 * @param :condition WHERE条件
	 * @param :param 参数
	 */
	public QueryHelper addWhereCondition(String condition, Object... param) {
		// 子句
		if (whereClause == null) {
			whereClause = new StringBuffer(" WHERE " + condition);
		} else {
			whereClause.append(" AND " + condition);
		}
		// 参数
		if (param != null) {
			for (Object object : param) {
				parameters.add(object);
			}
		}
		return this;
	}
	
	public QueryHelper addWhereCondition(boolean append, String condition, Object... param) {
		if (append) {
			addWhereCondition(condition, param);
		}
		return this;
	}
	
	/**
	 * 拼接order by子句
	 * 
	 * @param :propertyName 参与排序的属性名
	 * @param :asc true升序，false降序
	 */
	public QueryHelper addOrderByProperty(String propertyName, boolean asc) {
		if (orderByClause == null) {
			orderByClause = new StringBuffer(" ORDER BY  " + propertyName + (asc ? " ASC " : " DESC "));
		} else {
			orderByClause.append(" , " + propertyName + (asc ? " ASC " : " DESC "));
		}
		return this;
	}
	
	public QueryHelper addOrderByProperty(boolean append, String propertyName, boolean asc) {
		if (append) {
			addOrderByProperty(propertyName, asc);
		}
		return this;
	}
	
	/**
	 * 获取生成的用于查询数据列表的HQL语句
	 * 
	 * @return
	 */
	public String getListQueryHQL() {
		return "" + fromClause + (whereClause == null ? "" : whereClause) + (orderByClause == null ? "" : orderByClause);
	}
	
	/**
	 * 获取记录条数
	 * 
	 * @return
	 */
	public String getCountQueryHQL() {
		return "SELECT COUNT(*) " + fromClause + (whereClause == null ? "" : whereClause);
	}
	
	public StringBuffer getFromClause() {
		return fromClause;
	}
	
	public void setFromClause(StringBuffer fromClause) {
		this.fromClause = fromClause;
	}
	
	public StringBuffer getWhereClause() {
		return whereClause;
	}
	
	public void setWhereClause(StringBuffer whereClause) {
		this.whereClause = whereClause;
	}
	
	public StringBuffer getOrderByClause() {
		return orderByClause;
	}
	
	public void setOrderByClause(StringBuffer orderByClause) {
		this.orderByClause = orderByClause;
	}
	
	public List<Object> getParameters() {
		return parameters;
	}
	
	public void setParameters(List<Object> parameters) {
		this.parameters = parameters;
	}
}
