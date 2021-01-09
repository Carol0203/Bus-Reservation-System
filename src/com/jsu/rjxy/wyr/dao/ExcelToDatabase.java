package com.jsu.rjxy.wyr.dao;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.jsu.rjxy.wyr.dao.DatabaseConnectionSql;

public class ExcelToDatabase {
	private static StringBuffer fileName = new StringBuffer("D:\\车票查询预定系统-管理员信息表.xls");
	// 返回有几条重复或者出错的数据

	public static void toReadExcel(String name) {
		// 插入Excel中的值
		getAllByExcel();		
	}

	/*
	 * 获取Excel中的数据
	 */
	private static void getAllByExcel() {
		MngRecord data = new MngRecord();
			// 获得工作薄
			Workbook workBook=null;
			try {
				workBook = Workbook.getWorkbook(new File(fileName.toString()));
			} catch (BiffException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 获得工作表
			Sheet sheet = workBook.getSheet(0);

			// 获得行和列的长度
			int col = sheet.getColumns();
			int row = sheet.getRows();

			System.out.println("col = " + col + " rows = " + row);

			for (int i = 1; i < row; i++) {
				for (int j = 0; j < col; j++) {
					// 获得数据
					String mngusername = sheet.getCell(j++, i).getContents();
					String mngpassword = sheet.getCell(j++, i).getContents();
					// 输出数据
					System.out.println(" mngusername = " + mngusername + " mngpassword = " + mngpassword);
					/*
					 * 添加到数据库 如果数据库中的表设置主键 应该先判断插入的值是否在数据库中存在， 存在就更新，没有就直接插入
					 */
					String[] str = new String[] { mngusername, mngpassword};	
						// 插入数据库
						insertToDB(str);
				}
			}
	}

	private static void insertToDB(String[] str) {
		String sql = "insert into management (mngusername,mngpassword) values(?,?)";
		// 添加到数据库
		DatabaseConnectionSql.add(sql, str);
	}

	public static void main(String args[]) {
		toReadExcel(fileName.toString());
	}
}
