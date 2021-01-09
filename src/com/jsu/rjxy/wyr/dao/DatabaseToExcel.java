package com.jsu.rjxy.wyr.dao;

import java.io.File;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DatabaseToExcel {
	// 创建可写入的Excel工作薄
	private static String fileName = "D:\\车票查询预定系统-汽车信息表.xls";
	
	public static void toWriteExcel() {
		try {
    		WritableWorkbook excelBook = null;
    		// 打开文件
    		File file = new File(fileName);
    		// 查看文件是否存在
    		if(!file.exists()) {
    			// 不存在创建
    			file.createNewFile();
    		}
    		
    		//以fileName为文件名来创建一个Workbook
    		excelBook = Workbook.createWorkbook(file);
    		
    		//创建工作表
    		WritableSheet excelSheet = excelBook.createSheet("Test 1", 0);
    		
    		List<CarRecord> list = DatabaseConnectionSql.getAllCarRecord("select * from selecting", null);
    		
    		//要插入到的Excel表格的行号，默认从0开始
    		Label labelCarnumber = new Label(0, 0 , "carnumber");
    		Label labelStart = new Label(1, 0 , "start");
    		Label labelDestination = new Label(2, 0 , "destination");
    		Label labelTime = new Label(3, 0 , "time");
    		Label labelPrice = new Label(4, 0 , "price");
    		Label labelTicket = new Label(5, 0 , "ticket");
    		
    		//添加第一列到单元格
    		excelSheet.addCell(labelCarnumber);
    		excelSheet.addCell(labelStart);
    		excelSheet.addCell(labelDestination);
    		excelSheet.addCell(labelTime);
    		excelSheet.addCell(labelPrice);
    		excelSheet.addCell(labelTicket);
    		
    		// 导入
    		for(int i = 0; i < list.size(); i++) {
    			//要插入到的Excel表格的行号，默认从0开始
        		Label label_Carnumber = new Label(0, i+1 , list.get(i).getCarnumber());
        		Label label_Start = new Label(1, i+1 , list.get(i).getStart() + "");
        		Label label_Destination = new Label(2, i+1 , list.get(i).getDestination());
        		Label label_Time = new Label(3, i+1 , list.get(i).getTime());
        		Label label_Price = new Label(4, i+1 , list.get(i).getPrice() + "");
        		Label label_Ticket = new Label(5, i+1 , list.get(i).getTicket() + "");
        		
        		//添加第一列到单元格
        		excelSheet.addCell(label_Carnumber);
        		excelSheet.addCell(label_Start);
        		excelSheet.addCell(label_Destination); 
        		excelSheet.addCell(label_Time);
        		excelSheet.addCell(label_Price);
        		excelSheet.addCell(label_Ticket);
    		}
    		
    		//写入文档
    		excelBook.write();
    		//关闭Excel工作薄对象
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

