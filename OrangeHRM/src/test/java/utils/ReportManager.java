package utils;

import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import common.SeleniumTest;

public class ReportManager extends SeleniumTest{
	
	/**
	 * To pass the step and take the screen shot
	 * @param message
	 */
	public static void reportPassed(String message) {
		imagePath = takeScreenShot();
		imageFolderPath = test.addScreenCapture(imagePath);
		
		Reporter.log(message);
		
		test.log(LogStatus.PASS, message, imageFolderPath);
		
		sAssert.assertTrue(true, message);
	}
	
	/**
	 * To fail the step, take the screen shot and proceed with the execution
	 * @param message
	 */
	public static void reportFailed(String message) {
		imagePath = takeScreenShot();
		imageFolderPath = test.addScreenCapture(imagePath);
		
		Reporter.log(message);
		
		test.log(LogStatus.FAIL, message, imageFolderPath);
		
		sAssert.assertTrue(false, message);
	}
	
	/**
	 * To fail the step, take the screen shot and abort the execution
	 * @param message
	 */
	public static void fail(String message) {
		imagePath = takeScreenShot();
		imageFolderPath = test.addScreenCapture(imagePath);
		
		Reporter.log(message);
		
		test.log(LogStatus.FAIL, message, imageFolderPath);
		
		Assert.fail(message);
	}

}
