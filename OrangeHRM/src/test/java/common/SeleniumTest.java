package common;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class SeleniumTest {

	protected static WebDriver driver = null;
	protected static ExtentReports report = null;
	protected static ExtentTest test = null;
	protected static String testName = null;
	protected static String imagePath = null;
	protected static String imageFolderPath = null;
	protected ITestResult result = null;
	protected static SoftAssert sAssert = new SoftAssert();

	private static int imageNo = 1;

	public SeleniumTest() {
		report = new ExtentReports("./ExtentReports/" + testName + ".html", true);
		test = report.startTest(testName);
	}

	public static String takeScreenShot() {

		String strImageNo = null;
		try{
			strImageNo = String.format("%03d", imageNo);  // 0009   
			String screenShotPath = "C:/Users/sceekala/Desktop/Sanjay Ceekala/Automation/Workspaces/MyFrameWorkOrangeHRM/OrangeHRM/screenshots/" + testName + "/" + strImageNo + ".png";
			TakesScreenshot screenshot = (TakesScreenshot) driver; 
			File screenShotFile = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShotFile, new File(screenShotPath));
			imageNo++;

			return screenShotPath;
		}catch (Exception iOException) {
			return "";
		}
	}


}
