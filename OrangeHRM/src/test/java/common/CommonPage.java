package common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.LogStatus;

public class CommonPage extends SeleniumTest{
	
	@BeforeMethod
	public void setUp(ITestResult result) {
		this.result = result;
		
		testName = result.getMethod().getMethodName();
		Reporter.log("Running... : " + testName, true);
		
		initializeDriver();
		openApplication();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		report.endTest(test);
		report.flush();
		
		if(test.getRunStatus() == LogStatus.FAIL)
			Assert.fail("Test Failed : One or more steps failed");
		
		sAssert.assertAll();
	}
	
//	@AfterSuite
//	public void tearDownSuite() {
//		report.flush();
//	}

	private void initializeDriver() {
		String workingDir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", workingDir + "/src/main/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	private void openApplication() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}

}
