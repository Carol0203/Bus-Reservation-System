package com.jsu.rjxy.wyr.dao;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.jsu.rjxy.wyr.dao.DatabaseConnectionSql;

public class ExcelToDatabase {
	private static StringBuffer fileName = new StringBuffer("D:\\��Ʊ��ѯԤ��ϵͳ-����Ա��Ϣ��.xls");
	// �����м����ظ����߳��������

	public static void toReadExcel(String name) {
		// ����Excel�е�ֵ
		getAllByExcel();		
	}

	/*
	 * ��ȡExcel�е�����
	 */
	private static void getAllByExcel() {
		MngRecord data = new MngRecord();
			// ��ù�����
			Workbook workBook=null;
			try {
				workBook = Workbook.getWorkbook(new File(fileName.toString()));
			} catch (BiffException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// ��ù�����
			Sheet sheet = workBook.getSheet(0);

			// ����к��еĳ���
			int col = sheet.getColumns();
			int row = sheet.getRows();

			System.out.println("col = " + col + " rows = " + row);

			for (int i = 1; i < row; i++) {
				for (int j = 0; j < col; j++) {
					// �������
					String mngusername = sheet.getCell(j++, i).getContents();
					String mngpassword = sheet.getCell(j++, i).getContents();
					// �������
					System.out.println(" mngusername = " + mngusername + " mngpassword = " + mngpassword);
					/*
					 * ��ӵ����ݿ� ������ݿ��еı��������� Ӧ�����жϲ����ֵ�Ƿ������ݿ��д��ڣ� ���ھ͸��£�û�о�ֱ�Ӳ���
					 */
					String[] str = new String[] { mngusername, mngpassword};	
						// �������ݿ�
						insertToDB(str);
				}
			}
	}

	private static void insertToDB(String[] str) {
		String sql = "insert into management (mngusername,mngpassword) values(?,?)";
		// ��ӵ����ݿ�
		DatabaseConnectionSql.add(sql, str);
	}

	public static void main(String args[]) {
		toReadExcel(fileName.toString());
	}
}
