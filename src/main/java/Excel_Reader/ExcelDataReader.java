package Excel_Reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataReader {
	
	public static ArrayList<String> getTestCasesNames() throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestCase_Selenium.xlsx");
	     Workbook book = WorkbookFactory.create(fis);
	      Sheet sh = book.getSheet("TestCases");
	      int lastRowNum = sh.getPhysicalNumberOfRows();
	      
	   ArrayList<String> arr=new  ArrayList();
	   
	   for(int i=1;i<lastRowNum;i++) {
		   arr.add(sh.getRow(i).getCell(0).toString());
		   
		   
	   }
	     
	return arr;
	}
	public static ArrayList<String> getKeyword(String sheetName) throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestCase_Selenium.xlsx");
	     Workbook book = WorkbookFactory.create(fis);
	      Sheet sh = book.getSheet(sheetName);
	      System.out.println(sheetName);
	      int lastRowNum = sh.getPhysicalNumberOfRows();
	      ArrayList<String> arr=new  ArrayList<>();
		   
		   for(int i=1;i<lastRowNum;i++) {
			   arr.add(sh.getRow(i).getCell(6).toString());
		   }
		     
		return arr;  
	}
	public static String getTestData(String sheetName, int rowNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestCase_Selenium.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		return sh.getRow(rowNum).getCell(5).toString();
	}

	public static String getLocators(String sheetName, int rowNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestCase_Selenium.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		return sh.getRow(rowNum).getCell(7).toString();
	}

}

