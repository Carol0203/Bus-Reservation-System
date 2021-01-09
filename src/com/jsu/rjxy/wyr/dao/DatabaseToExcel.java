package com.jsu.rjxy.wyr.dao;

import java.io.File;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DatabaseToExcel {
	// ������д���Excel������
	private static String fileName = "D:\\��Ʊ��ѯԤ��ϵͳ-������Ϣ��.xls";
	
	public static void toWriteExcel() {
		try {
    		WritableWorkbook excelBook = null;
    		// ���ļ�
    		File file = new File(fileName);
    		// �鿴�ļ��Ƿ����
    		if(!file.exists()) {
    			// �����ڴ���
    			file.createNewFile();
    		}
    		
    		//��fileNameΪ�ļ���������һ��Workbook
    		excelBook = Workbook.createWorkbook(file);
    		
    		//����������
    		WritableSheet excelSheet = excelBook.createSheet("Test 1", 0);
    		
    		List<CarRecord> list = DatabaseConnectionSql.getAllCarRecord("select * from selecting", null);
    		
    		//Ҫ���뵽��Excel�����кţ�Ĭ�ϴ�0��ʼ
    		Label labelCarnumber = new Label(0, 0 , "carnumber");
    		Label labelStart = new Label(1, 0 , "start");
    		Label labelDestination = new Label(2, 0 , "destination");
    		Label labelTime = new Label(3, 0 , "time");
    		Label labelPrice = new Label(4, 0 , "price");
    		Label labelTicket = new Label(5, 0 , "ticket");
    		
    		//��ӵ�һ�е���Ԫ��
    		excelSheet.addCell(labelCarnumber);
    		excelSheet.addCell(labelStart);
    		excelSheet.addCell(labelDestination);
    		excelSheet.addCell(labelTime);
    		excelSheet.addCell(labelPrice);
    		excelSheet.addCell(labelTicket);
    		
    		// ����
    		for(int i = 0; i < list.size(); i++) {
    			//Ҫ���뵽��Excel�����кţ�Ĭ�ϴ�0��ʼ
        		Label label_Carnumber = new Label(0, i+1 , list.get(i).getCarnumber());
        		Label label_Start = new Label(1, i+1 , list.get(i).getStart() + "");
        		Label label_Destination = new Label(2, i+1 , list.get(i).getDestination());
        		Label label_Time = new Label(3, i+1 , list.get(i).getTime());
        		Label label_Price = new Label(4, i+1 , list.get(i).getPrice() + "");
        		Label label_Ticket = new Label(5, i+1 , list.get(i).getTicket() + "");
        		
        		//��ӵ�һ�е���Ԫ��
        		excelSheet.addCell(label_Carnumber);
        		excelSheet.addCell(label_Start);
        		excelSheet.addCell(label_Destination); 
        		excelSheet.addCell(label_Time);
        		excelSheet.addCell(label_Price);
        		excelSheet.addCell(label_Ticket);
    		}
    		
    		//д���ĵ�
    		excelBook.write();
    		//�ر�Excel����������
    		excelBook.close();
    	}
    	 catch (Exception e) {
             e.printStackTrace();
         }
	}
	
    public static void main(String args[]) {
    	toWriteExcel();
    }
}

