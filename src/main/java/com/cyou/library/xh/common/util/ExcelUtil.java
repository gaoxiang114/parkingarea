package com.cyou.library.xh.common.util;

import java.io.*;

import java.lang.reflect.*;

import java.util.*;

import java.util.logging.Logger;
import java.util.regex.Matcher;

import java.util.regex.Pattern;

import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.*;

import org.apache.poi.hssf.util.HSSFColor;

import com.cyou.library.xh.book.domain.Book;



public class ExcelUtil<T> {
	
	public void exportExcel(Collection<T> dataList, OutputStream out) {
		exportExcel("数据表格", null, dataList, out, "yyyy-MM-dd");
	}

	public void exportExcel(List<String> headerList, Collection<T> dataList,OutputStream out) {
		exportExcel("数据表格", headerList, dataList, out, "yyyy-MM-dd");
	}

	public void exportExcel(List<String> headerList, Collection<T> dataList,OutputStream out, String pattern) {
		exportExcel("数据表格", headerList, dataList, out, pattern);
	}

	@SuppressWarnings("unchecked")
	public void exportExcel(String title, List<String> headerList,Collection<T> dataList, OutputStream out, String pattern) {

		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 15);
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();

		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 生成一个字体

		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);

		// 生成并设置另一个样式
		HSSFCellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		HSSFFont font2 = workbook.createFont();
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		style2.setFont(font2);
		// 声明一个画图的顶级管理器
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// 定义注释的大小和位置

		HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
		comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
		// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		comment.setAuthor("gx");
		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);

		for (short i = 0; i < headerList.size(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(headerList.get(i));
			cell.setCellValue(text);
		}

		// 遍历集合数据，产生数据行
		Iterator<T> itor = dataList.iterator();
		int index = 0;
		while (itor.hasNext()) {
			index++;
			row = sheet.createRow(index);
			T t = (T) itor.next();
			// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
			Field[] fields = t.getClass().getDeclaredFields();
			for (short i = 0; i < fields.length; i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style2);
				Field field = fields[i];
				String fieldName = field.getName();
				String getMethodName = "get"+ fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);

				try {
					Class tCls = t.getClass();
					Method method = tCls.getMethod(getMethodName,new Class[] {});
					Object value = method.invoke(t, new Object[] {});
					
					System.out.println(value+"=----------------->"+(i+1));
					// 判断值的类型后进行强制类型转换
					String textValue = null;

					if (value instanceof Boolean) {
						boolean bValue = (Boolean) value;
						textValue = "男";
						if (!bValue) {
							textValue = "女";
						}
					} else if (value instanceof Date) {
						Date date = (Date) value;
						SimpleDateFormat sdf = new SimpleDateFormat(pattern);
						textValue = sdf.format(date);
					} else if (value instanceof byte[]) {
						// 有图片时，设置行高为60px;
						row.setHeightInPoints(60);
						// 设置图片所在列宽度为80px,注意这里单位的一个换算
						sheet.setColumnWidth(i, (short) (35.7 * 80));
						// sheet.autoSizeColumn(i);
						byte[] bsValue = (byte[]) value;
						HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,1023, 255, (short) 6, index, (short) 6, index);
						anchor.setAnchorType(2);
						patriarch.createPicture(anchor, workbook.addPicture(
						bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
					} else {
						// 其它数据类型都当作字符串简单处理
						textValue = value.toString();
					}
					// 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
					if (textValue != null) {
						Pattern p = Pattern.compile("^//d+(//.//d+)?$");
						Matcher matcher = p.matcher(textValue);
						if (matcher.matches()) {
							// 是数字当作double处理
							cell.setCellValue(Double.parseDouble(textValue));
						} else {
							HSSFRichTextString richString = new HSSFRichTextString(textValue);
							HSSFFont font3 = workbook.createFont();
							font3.setColor(HSSFColor.BLUE.index);
							richString.applyFont(font3);
							cell.setCellValue(richString);
						}
					}
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();

				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} finally {
					// 清理资源
				}
			}
		}

		try {
				System.out.println(out+"========================>");
			workbook.write(out);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		ExcelUtil<Book> ex2 = new ExcelUtil<Book>();

		List headerList = new ArrayList<String>();
		headerList.add("图书编号");
		headerList.add("图书名称");
		headerList.add("图书作者");
		headerList.add("图书价格");
		headerList.add("图书ISBN");
		headerList.add("图书出版社");
		
		List<Book> dataList = new ArrayList<Book>();

		try {
			/*dataList.add(new Book(1, "jsp", "leno", 300.33f, "1234567","清华出版社"));
			dataList.add(new Book(2, "java编程思想", "brucl", 300.33f, "1234567","阳光出版社"));
			dataList.add(new Book(3, "DOM艺术", "lenotang", 300.33f, "1234567","清华出版社"));
			dataList.add(new Book(4, "c++经典", "leno", 400.33f, "1234567","清华出版社"));
			dataList.add(new Book(5, "c#入门", "leno", 300.33f, "1234567","汤春秀出版社"));*/

			OutputStream out = new FileOutputStream("E://b.xls");

			ex2.exportExcel("图书表格",headerList, dataList, out,"yyyy-MM-dd");
			out.close();
			JOptionPane.showMessageDialog(null, "导出成功!");
			System.out.println("excel导出成功！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}