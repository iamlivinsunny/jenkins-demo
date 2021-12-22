package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActions {

	private static WebDriver driver;

	public static String getText(WebDriver driver, By byObject, int waitTime) {
		String content = null;
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(byObject)).getText();
		} catch (Exception ex) {
			return null;
		}

	}

	public static String getText(WebDriver driver, WebElement parentElement, By childElementByObject, int waitTime) {
		String content = null;
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		try {
			return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentElement, childElementByObject))
					.getText();
		} catch (Exception ex) {
			return null;
		}

	}

	public static String getTextUsingJavaScript(WebDriver driver, By byObject, int waitTime) {
		String content = null;
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		try {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(byObject));
			content = element.getText();
			if (content == null || content.trim() == "") {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				content = (String) jse.executeScript(" return arguments[0].textContent", element);
			}
		} catch (Exception ex) {
			return null;
		}
		return content;
	}
	
	
	public static String getTextUsingJavaScript(WebDriver driver, WebElement element, int waitTime) {
		String content = null;
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		try {
			content = element.getText();
			if (content == null || content.trim() == "") {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				content = (String) jse.executeScript(" return arguments[0].textContent", element);
			}
		} catch (Exception ex) {
			return null;
		}
		return content;
	}
	

	public static String getAttribute(WebDriver driver, WebElement parentElement, By childElementByObject,
			String attribute, int waitTime) {
		String content = null;
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		try {
			return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentElement, childElementByObject))
					.getAttribute(attribute);
		} catch (Exception ex) {
			return null;
		}

	}

}
