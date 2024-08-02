package TestScripts;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;

import Excel_Reader.ExcelDataReader;
import Utility_Library.KeyWords_Utility;

public class ScriptsDriver {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	
	
	KeyWords_Utility keywords_Utility = new KeyWords_Utility();
	
	ArrayList<String> alltestCaseNames = ExcelDataReader.getTestCasesNames();
		
	for(String testCasename : alltestCaseNames)
	{
		
		ArrayList<String> allKeyWords = ExcelDataReader.getKeyword(testCasename);
		
		int cellNumber=2;
		for(String keyword : allKeyWords)
		{
			switch (keyword) {
			case "Launchbrowser":
				keywords_Utility.launchBrowser();
				break;
			case "EnterUrl":
				keywords_Utility.enterUrl(ExcelDataReader.getTestData(testCasename, cellNumber));
				break;
			case "LoginButton":
				keywords_Utility.click(ExcelDataReader.getLocators(testCasename, cellNumber));
				break;
			case "AccountButton":
				keywords_Utility.enterData(ExcelDataReader.getLocators(testCasename, cellNumber),ExcelDataReader.getTestData(testCasename, cellNumber));
				break;
			case "verifyByMessage":
				keywords_Utility.verify(ExcelDataReader.getLocators(testCasename, cellNumber), testCasename);
				keywords_Utility.closeBrowser();
				break;
			default:
				break;
			}
			cellNumber++;
		}
		
	}

}
}
