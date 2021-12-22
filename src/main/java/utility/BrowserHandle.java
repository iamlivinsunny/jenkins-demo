package utility;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BrowserHandle {

	public static String[] createNewWindowAndSwitchToTheWindow(WebDriver driver, String url) {
		try {
			JavascriptExecutor jsExe = (JavascriptExecutor) driver;
			jsExe.executeScript("window.open(arguments[0], '_blank');", url);
			Set<String> windowHandle = driver.getWindowHandles();
			driver.switchTo().window((String) windowHandle.toArray()[1]);
			String title = WebActions.getTextUsingJavaScript(driver, By.xpath("//h1"), 1);
			String description = WebActions.getTextUsingJavaScript(driver, By.xpath("//div/article"), 1);
			if (description == null || description.trim().equals("")) {
				description = WebActions.getTextUsingJavaScript(driver, By.xpath("//article/p"), 1);
				if (description == null || description.trim().equals(""))
					description = WebActions.getTextUsingJavaScript(driver, By.xpath("//p"), 1);
			}
			driver.close();
			driver.switchTo().window((String) windowHandle.toArray()[0]);
			return new String[] { "", title, description };
		} catch (Exception ex) {

		}
		return null;
	}

}
