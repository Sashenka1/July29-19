package com.syntax.testcases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteDemo {
	
	public void writeExcell() throws IOException{ 

	String xlPath="src/test/resources/TestData/OrangeHRM.xlsx";
    
    FileInputStream fis =new FileInputStream(xlPath);
    
    XSSFWorkbook wbook=new XSSFWorkbook(fis);
    XSSFSheet sheet=wbook.getSheet("EmployeeDetails");
    
    //write some values 
    
    sheet.getRow(0).createCell(3).setCellValue("Results");
    sheet.getRow(1).createCell(2).setCellValue("Results");
    sheet.getRow(3).createCell(3).setCellValue("Results");
    //write to Excell
    
    FileOutputStream fos=new FileOutputStream(xlPath);
    wbook.write(fos);
    //close file and open stream 
    fos.close();
    wbook.close();
    fis.close();
    
    
    
	
}}
