package utils;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import common.SeleniumTest;

public class FillUtils extends SeleniumTest{

	/**
	 * To fill the text in the input field
	 * @param locator
	 * @param inputText
	 * @throws IOException 
	 */

	public static void fillInputOrFail(By locator, String inputText, String fieldName) {
		WebElement element = driver.findElement(locator);
		if(element != null && (element.isDisplayed() && element.isEnabled())) {
			element.sendKeys(inputText);
			ReportManager.reportPassed("The text is entered in the " + fieldName + " field");
		}
		else {
			ReportManager.reportFailed("The text is entered in the " + fieldName + " field");
		}

	}

	/**
	 * To select the dropdown value by text
	 * @param locator
	 * @param text
	 * @throws IOException 
	 */

	public static void fillSelectByVisibleText(By locator, String text, String fieldName) {
		WebElement element = driver.findElement(locator);

		if(element != null && (element.isDisplayed() && element.isEnabled())) {
			Select select = new Select(element);
			select.selectByVisibleText(text);
			ReportManager.reportPassed("The option is selected in the " + fieldName + " field");
		}
		else {
			ReportManager.reportFailed(fieldName + " field is not present");
		}
	}

	/**
	 * To select the dropdown by value
	 * @param locator
	 * @param text
	 */

	public static void fillSelectByValue(By locator, String text, String fieldName) {
		WebElement element = driver.findElement(locator);
		Select select = new Select(element);

		if(element != null && (element.isDisplayed() && element.isEnabled())) {
			select.selectByValue(text);
			ReportManager.reportPassed("The option is selected in the " + fieldName + " field");
		}
		else {
			ReportManager.reportFailed(fieldName + " field is not present");
		}
	}

	/**
	 * To select the dropdown by index
	 * @param locator
	 * @param text
	 */

	public static void fillSelectByIndex(By locator, int index, String fieldName) {
		WebElement element = driver.findElement(locator);
		Select select = new Select(element);

		if(element != null && (element.isDisplayed() && element.isEnabled())) {
			select.selectByIndex(index);
			ReportManager.reportPassed("The option is selected in the " + fieldName + " field");
		}
		else {
			ReportManager.reportFailed(fieldName + " field is not present");
		}
	}

}
