package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverHandle {

	private static WebDriver driver;

	public static WebDriver initalizeDriver(String url) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/driver/chromedriver.exe");
		// set chrome options
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
		options.addArguments("start-maximized");
		// initialize driver
		driver = new ChromeDriver(options);
		driver.get(url);
		Thread.sleep(10000);
		return driver;
	}

}
