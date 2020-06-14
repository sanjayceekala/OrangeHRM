package utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import Helpers.CustomReporter;
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
			imagePath = takeScreenShot();
			imageFolderPath = test.addScreenCapture(imagePath);
			test.log(LogStatus.PASS, "The text is entered in the " + fieldName + " field", imageFolderPath);
		}
		else {
			imagePath = takeScreenShot();
			imageFolderPath = test.addScreenCapture(imagePath);
			test.log(LogStatus.FAIL, fieldName + " field is not present", imageFolderPath);
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
			imagePath = takeScreenShot();
			imageFolderPath = test.addScreenCapture(imagePath);
			test.log(LogStatus.PASS, "The option is not selected in the " + fieldName + " field", imageFolderPath);
		}
		else {
			imagePath = takeScreenShot();
			imageFolderPath = test.addScreenCapture(imagePath);
			test.log(LogStatus.FAIL, fieldName + " field is not present", imageFolderPath);
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
			imagePath = takeScreenShot();
			imageFolderPath = test.addScreenCapture(imagePath);
			test.log(LogStatus.PASS,  "The option is not selected in the " + fieldName + " field", imageFolderPath);
		}
		else {
			test.log(LogStatus.FAIL, fieldName + " field is not present", imageFolderPath);
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
			test.log(LogStatus.PASS,  "The option is not selected in the " + fieldName + " field", imageFolderPath);
		}
		else {
			test.log(LogStatus.FAIL, fieldName + " field is not present", imageFolderPath);
		}
	}

}
