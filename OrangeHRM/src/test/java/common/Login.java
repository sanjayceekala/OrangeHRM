package common;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.LogLevel;
import com.relevantcodes.extentreports.LogStatus;

import tests.sanity.Sanity_001_Add_Admin_User;

public class Login extends SeleniumTest{
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initializeDriver();
		openApplication();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		report.endTest(test);
		report.flush();
		
		if(test.getRunStatus().FAIL != null)
			Assert.assertTrue(false);
	}
	
	private void initializeDriver() {
		String workingDir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", workingDir + "/src/main/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	private void openApplication() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}

}
