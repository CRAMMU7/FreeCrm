package com.crm.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil  extends TestBase{
public static long PAGE_LOAD_TIMEOUT=20;
public static long  IMPLICIT_WAIT=10;
public static String TESTDATA_SHEET_PATH="C:\\javaprojectsjee\\FreecrmTest\\src\\main\\java\\com\\crm\\qa\\testdata\\ZooplaTestData.xlsx";
static Workbook book;
static Sheet sheet;
public static Object[][] getTestData(String sheetName) {
	
	FileInputStream ip= null;
	try {
		ip=new FileInputStream(TESTDATA_SHEET_PATH);
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
	try {
		book=WorkbookFactory.create(ip);
	} catch (InvalidFormatException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	sheet=book.getSheet(sheetName);
	Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()] ;
	for(int i=0;i<sheet.getLastRowNum();i++)
	{
		for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)	
		{
			data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		}
	}
	return data;
	
}

public static  void takeScreenshotAtEndOfTest() throws IOException {
File scrFile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
String path=System.getProperty("user.dir");
FileUtils.copyFile(scrFile,new File(path+"/screenshots/"+System.currentTimeMillis()+".png"));


}	
}

	


