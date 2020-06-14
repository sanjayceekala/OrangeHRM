package common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogLevel;
import com.relevantcodes.extentreports.LogStatus;

public class SeleniumTest {

	protected static WebDriver driver = null;
	protected static ExtentReports report = null;
	protected static ExtentTest test = null;
	protected static String testName = null;
	protected static String imagePath = null;
	protected static String imageFolderPath = null;
	private static String strImageNo = null;
	
	private static int imageNo = 1;

	public SeleniumTest() {
		report = new ExtentReports("./ExtentReports/" + testName + ".html", true);
		test = report.startTest(testName);
	}
	
	public static String takeScreenShot() {
		
		try{
			
			strImageNo = String.format("%03d", imageNo);  // 0009   
			String screenShotPath = "C:/Users/sceekala/Desktop/Sanjay Ceekala/Automation/Workspaces/MyFrameWorkOrangeHRM/OrangeHRM/screenshots/" + testName + "/" + strImageNo + ".png";
			TakesScreenshot screenshot = (TakesScreenshot) driver; 
			File screenShotFile = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShotFile, new File(screenShotPath));
			test.log(LogStatus.INFO, "Image No " + imageNo);
			imageNo++;
			return screenShotPath;
		}catch (Exception iOException) {
			return "";
		}
		
		
	}


}
