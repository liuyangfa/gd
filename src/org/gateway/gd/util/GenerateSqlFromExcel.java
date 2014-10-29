/**
 * @author gateway
 * Excel数据导入数据库
 * @version 1.0
 */
package org.gateway.gd.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;

public class GenerateSqlFromExcel {

	/**
	 * 导入报表Excel数据，生成用户表的数据库导入语句
	 * 
	 * @param formFile
	 *            ，excel的文件
	 * @return list ArrayList
	 * @throws Exception
	 */
	public static ArrayList<String[]> generateUserSql(File formFile)
			throws Exception {
		InputStream in = null;
		Workbook wb = null;
		ArrayList<String[]> list = new ArrayList<String[]>();

		try {
			if (formFile == null) {
				throw new Exception("文件为空！");
			}

			in = new FileInputStream(formFile);// 将文件转换成输入流

			wb = Workbook.getWorkbook(in);// 将文件转换成WorkBook对象，WorkBook也是jxl的核心对象

			Sheet sheet[] = wb.getSheets();// 使用Workbook获取Sheet对象，是一个数组
			if (sheet != null) {
				for (int i = 0; i < sheet.length; i++) {
					int count = i + 1;
					if (!sheet[i].getName().equalsIgnoreCase("User" + count)) {
						throw new Exception("指定文件中不包含名称为User的sheet,请重新指定！");
					}
					for (int j = 1; j < sheet[i].getRows(); j++) {// 从Sheet对象中获取row对象，循环每一行
						String[] valStr = new String[20];// 注意：数组的长度不能小于excel文件的列数
						for (int k = 0; k < sheet[i].getColumns(); k++) {// 从Sheet对象中获取columns对象，循环每一列
							/**
							 * getCell(int column, int row)
							 */
							Cell cell = sheet[i].getCell(k, j);// 表示获取第j行，第k列的值，获取cell对象
							String content = "";
							if (cell.getType() == CellType.DATE) {// 当前单元格cell的类型是日期类型
								DateCell dateCell = (DateCell) cell;
								java.util.Date importdate = dateCell.getDate();
								/** 如果excel是日期格式的话需要减去8小时 */
								long eighthour = 8 * 60 * 60 * 1000;
								SimpleDateFormat simpledate = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss");
								/** 在当前日期上减8小时 */
								long time = importdate.getTime() - eighthour;
								java.util.Date date = new java.util.Date();
								date.setTime(time);
								content = simpledate.format(date);
							} else {
								String tempcontent = (cell.getContents() == null ? ""
										: cell.getContents());
								content = tempcontent.trim();
							}
							valStr[k] = content;

						}
						list.add(j - 1, valStr);
					}
				}
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (wb != null) {
				wb.close();
			}
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
