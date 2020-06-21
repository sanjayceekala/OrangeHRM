package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.SeleniumTest;

public class WaitUtils extends SeleniumTest{

	/**
	 * To wait for the element present
	 * @param locator
	 * @param timeOut
	 * @return
	 */

	public static boolean waitForElementPresent(By locator, String elementName, int timeOut) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			ReportManager.reportPassed("Element " + elementName + " is present");
			return true;
		}catch (Exception e) {
			ReportManager.reportFailed(e.getMessage());
			return false;
		}
	}

	/**
	 * To wait for the element to be visible
	 * @param locator
	 * @param timeOut
	 * @return
	 */

	public static boolean waitForElementVisible(By locator, String elementName, int timeOut) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			ReportManager.reportPassed("Element " + elementName + " is Visible");
			return true;
		}catch (Exception e) {
			ReportManager.reportFailed(e.getMessage());
			return false;
		}
	}

	/**
	 * To wait for the element to be not visible
	 * @param locator
	 * @param timeOut
	 * @return
	 */

	public static boolean waitForElementNotVisible(By locator, String elementName, int timeOut) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			ReportManager.reportPassed("Element " + elementName + " is not Visible");
			return true;
		}catch (Exception e) {
			ReportManager.reportFailed(e.getMessage());
			return false;
		}

	}

}