/**
 * 系统数据导出Excel 生成器
 * @version 1.0
 */
package org.gateway.gd.util;

import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

@SuppressWarnings("rawtypes")
public class ExcelFileGenerator {

	private final int SPLIT_COUNT = 15; // Excel每个工作簿的行数

	private ArrayList fieldName = null; // excel标题数据集

	private ArrayList fieldData = null; // excel数据内容

	private HSSFWorkbook workBook = null; // POI报表的核心对象

	/**
	 * 构造器
	 * 
	 * @param fieldName
	 *            结果集的字段名
	 * @param data
	 */
	public ExcelFileGenerator(ArrayList fieldName, ArrayList fieldData) {

		this.fieldName = fieldName;
		this.fieldData = fieldData;
	}

	/**
	 * 创建HSSFWorkbook对象
	 * 
	 * @return HSSFWorkbook
	 */
	@SuppressWarnings("deprecation")
	public HSSFWorkbook createWorkbook() {

		workBook = new HSSFWorkbook();// 创建workbook对象
		int rows = fieldData.size();
		int sheetNum = 0;

		if (rows % SPLIT_COUNT == 0) {
			sheetNum = rows / SPLIT_COUNT;
		} else {
			sheetNum = rows / SPLIT_COUNT + 1;
		}

		for (int i = 1; i <= sheetNum; i++) {
			HSSFSheet sheet = workBook.createSheet("Page " + i);// 使用wookbook对象创建sheet对象
			HSSFRow headRow = sheet.createRow((short) 0); // 使用HSSFSheet对象创建row，row的下标从0开始
			for (int j = 0; j < fieldName.size(); j++) {// 循环excel的标题
				HSSFCell cell = headRow.createCell((short) j);// 使用HSSFRow创建cell，cell的下标从0开始
				// 添加样式
				sheet.setColumnWidth((short) j, (short) 6000);// 设置每一列的宽度
				// 创建样式
				HSSFCellStyle cellStyle = workBook.createCellStyle();
				// 设置字体
				HSSFFont font = workBook.createFont();// 创建字体对象
				// 将字体变为粗体
				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				// 将字体颜色变红色
				short color = HSSFColor.RED.index;
				font.setColor(color);
				cellStyle.setFont(font);// 设置之后的字体

				// 添加样式
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);// 设置单元格的类型
				cell.setEncoding(HSSFCell.ENCODING_UTF_16);// 设置编码格式
				if (fieldName.get(j) != null) {
					cell.setCellStyle(cellStyle);
					cell.setCellValue((String) fieldName.get(j));// 赋值
				} else {
					cell.setCellStyle(cellStyle);
					cell.setCellValue("-");
				}
			}

			for (int k = 0; k < (rows < SPLIT_COUNT ? rows : SPLIT_COUNT); k++) {// 分页显示数据
				if (((i - 1) * SPLIT_COUNT + k) >= rows)
					break;
				HSSFRow row = sheet.createRow((short) (k + 1));// 使用HSSFSheet对象创建row，row的下标从0开始
				// 将数据内容放入excel单元格
				ArrayList rowList = (ArrayList) fieldData.get((i - 1)
						* SPLIT_COUNT + k);// 循环数据集
				for (int n = 0; n < rowList.size(); n++) {
					HSSFCell cell = row.createCell((short) n);
					// 使用HSSFRow创建cell，cell的下标从0开始
					cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					if (rowList.get(n) != null) {
						cell.setCellValue((String) rowList.get(n).toString());
					} else {
						cell.setCellValue("");
					}
				}
			}
		}
		return workBook;
	}

	public void expordExcel(OutputStream os) throws Exception {
		workBook = createWorkbook();// 创建工作簿对象excel
		workBook.write(os);// 将workbook对象写到输出流
		os.close();
	}

}
