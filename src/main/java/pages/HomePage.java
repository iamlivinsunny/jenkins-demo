package pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.WebActions;

public class HomePage {

	public LinkedHashMap<String, String[]> getAllURLPresent(WebDriver driver, String baseURL) {
		LinkedHashMap<String, String[]> linkDetails = null;
		
		try {	
			linkDetails = new LinkedHashMap<String, String[]>();
			// Get all possible elements with link
			List<WebElement> linkElements = driver.findElements(By.xpath("//a"));
			// Get the link details
			for (WebElement linkElement : linkElements) {
				// creating an array to store details
				String[] detailsArray = new String[2];
				// Finding all link elements
				detailsArray[0] = linkElement.getText();
				// Get the text of the link
				detailsArray[1] = null;
				// Get the url
				String url = linkElement.getAttribute("href");
				// update the url
				if (!url.contains("http"))
					url = baseURL + url;
				linkDetails.put(url, detailsArray);
			}
			
			// Get all possible elements with link
			linkElements = driver.findElements(By.xpath("//a/parent::h3/parent::div"));
			
			// Get the link details
			for (WebElement linkElement : linkElements) {
				// creating an array to store details
				String[] detailsArray = new String[2];
				// Finding all link elements
				detailsArray[0] = WebActions.getText(driver, linkElement, By.xpath(".//h3/a"), 0);
				// Get the text of the link
				detailsArray[1] = WebActions.getText(driver, linkElement, By.xpath(".//p"), 0);
				// Get the url
				String url = WebActions.getAttribute(driver, linkElement, By.xpath(".//h3/a"), "href", 0);
				// update the url
				if (!url.contains("http"))
					url = baseURL + url;
				linkDetails.put(url, detailsArray);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return linkDetails;
	}

}
