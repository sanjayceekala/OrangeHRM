package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import Helpers.CustomReporter;
import common.SeleniumTest;

public class WaitUtils extends SeleniumTest{

	/**
	 * To wait for the element present
	 * @param locator
	 * @param timeOut
	 * @return
	 */

	public static boolean waitForElementPresent(By locator, int timeOut) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			imagePath = takeScreenShot();
			imageFolderPath = test.addScreenCapture(imagePath);
			test.log(LogStatus.PASS, "Element is present", imageFolderPath);
			return true;
		}catch (Exception e) {
			imagePath = takeScreenShot();
			imageFolderPath = test.addScreenCapture(imagePath);
			test.log(LogStatus.FAIL, e.getMessage(), imageFolderPath);
			return false;
		}
	}

	/**
	 * To wait for the element to be visible
	 * @param locator
	 * @param timeOut
	 * @return
	 */

	public static boolean waitForElementVisible(By locator, int timeOut) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			imagePath = takeScreenShot();
			imageFolderPath = test.addScreenCapture(imagePath);
			test.log(LogStatus.PASS, "Element is Visible", imageFolderPath);
			return true;
		}catch (Exception e) {
			imagePath = takeScreenShot();
			imageFolderPath = test.addScreenCapture(imagePath);
			test.log(LogStatus.FAIL, e.getMessage(), imageFolderPath);
			return false;
		}
	}

	/**
	 * To wait for the element to be not visible
	 * @param locator
	 * @param timeOut
	 * @return
	 */

	public static boolean waitForElementNotVisible(By locator, int timeOut) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			imagePath = takeScreenShot();
			imageFolderPath = test.addScreenCapture(imagePath);
			test.log(LogStatus.PASS, "Element is not Visible", imageFolderPath);
			return true;
		}catch (Exception e) {
			test.log(LogStatus.FAIL, e.getMessage(), imageFolderPath);
			return false;
		}

	}

}