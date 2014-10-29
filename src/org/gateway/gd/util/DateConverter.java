package org.gateway.gd.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class DateConverter extends DefaultTypeConverter {
	// 日期格式化器，完成格式如2014-08-06，2014/08/06，14-08-06,2014.08.06的定义
	private DateFormat[] dateFormat = { new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("yyyy/MM/dd"),
			new SimpleDateFormat("yyyy.MM.dd"), };
	// 时间格式化器，完成格式如12：30：1100，12：30的定义
	private DateFormat[] timeFormat = { new SimpleDateFormat("HH:mm:ssss"),
			new SimpleDateFormat("HH:mm"), };

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object convertValue(Map context, Object value, Class toType) {
		if (toType.equals(java.sql.Date.class)) {// 如果是java.sql.Date.class类型
			String[] parameterValues = (String[]) value;// 获取原始字符串数据
			for (DateFormat format : dateFormat)
				try { // 使用3种格式化器转换日期
					return new java.sql.Date(format.parse(parameterValues[0])
							.getTime());
				} catch (ParseException e) {
				}
		} else if (toType.equals(java.sql.Time.class)) {// 如果是java.sql.Time.class类型
			String[] parameterValues = (String[]) value;// 获取原始字符串数据
			for (DateFormat format : timeFormat)
				try { // 使用2种格式化器转换日期
					return new java.sql.Time(format.parse(parameterValues[0])
							.getTime());
				} catch (ParseException e) {
				}
		} else if (toType.equals(java.util.Date.class)) {// 如果是java..Date.class类型
			String[] parameterValues = (String[]) value;// 获取原始字符串数据
			for (DateFormat format : dateFormat)
				try { // 使用3种格式化器转换日期
					return format.parse(parameterValues[0]);
				} catch (ParseException e) {
				}
		} else if (toType.equals(String.class)) { // 如果时字符串
			if (value instanceof java.sql.Date) {
			} else if (value instanceof java.sql.Time) {
			} else if (value instanceof java.util.Date) {
				return dateFormat[0].format((java.util.Date) value);
			} // 将Date类型转换为String类型
		}
		return super.convertValue(context, value, toType);// 否则调用父类方法

	}
}
