package Utility_Library;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyWords_Utility {
	
	public static WebDriver driver;

	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void enterUrl(String Url) {
		driver.get(Url);
	}

	public void click(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void enterData(String xpath, String testData) {
		driver.findElement(By.xpath(xpath)).sendKeys(testData);
	}

	public void verify(String xpath, String sheetName) {
		try {
			driver.findElement(By.xpath(xpath)).isDisplayed();
			System.out.println(sheetName + " - Pass");
		} catch (Exception e) {
			System.out.println(sheetName + " - Fail");
		}
	}

	public void closeBrowser() {
		driver.quit();
	}

}
