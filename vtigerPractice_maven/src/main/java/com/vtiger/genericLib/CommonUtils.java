package com.vtiger.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;




import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CommonUtils {
	String pathExcel="./src/test/resources/testData.xlsx";
	String pathProperties="./src/test/resources/commonData.properties";
	public String getDataFromExcel(String sheetName,int rowNum,int ColNum) throws Throwable
	{
//		get the java representation object of physical file
		FileInputStream fis=new FileInputStream(pathExcel);
//		open the workbook in read mode
		Workbook wb=WorkbookFactory.create(fis);
//		get the control of the sheet
		Sheet sh=wb.getSheet(sheetName);
//		get the contrl of the row
		Row row=sh.getRow(rowNum);
//		get the data from cell
		String data=row.getCell(ColNum).getStringCellValue();
		wb.close();
		return data;
		}
	public Properties getDataFromProperyFile() throws Throwable
	{
//		get the java object representation of physical file
		FileInputStream fispro=new FileInputStream(pathProperties);
//		create the object to property file
		Properties pro=new Properties();
//		load all the data in form of key value 
		pro.load(fispro);
        return pro;
	}


}
