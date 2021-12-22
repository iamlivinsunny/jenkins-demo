package tests;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import utility.DriverHandle;
import utility.ExcelHandle;

public class Test_001_ScrapBBCWebsite {
	WebDriver driver;
	String url;

	@BeforeTest
	public void startExecution() throws InterruptedException {
		url = "https://www.bbc.com/";
		driver = DriverHandle.initalizeDriver(url);
	}

	@Test
	public void getBBCWebSiteDetails() throws IOException {
		String resultPath = "C:\\Users\\TestingAccount\\Desktop\\Extracted Results";
		HomePage oHomePage = new HomePage();
		LinkedHashMap<String, String[]> detailsMap = oHomePage.getAllURLPresent(driver, url);
//		ExcelHandle.writeUrlDataIntoExcelFile(System.getProperty("user.dir") + "/ExcelResult", detailsMap);
		ExcelHandle.writeUrlDataIntoExcelFile("C:\\Users\\TestingAccount\\Desktop\\Extracted Results", detailsMap);
	}

	@AfterTest
	public void stopExecution() {
		driver.quit();
	}
}
