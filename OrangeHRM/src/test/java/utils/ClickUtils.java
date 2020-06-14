package utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import common.SeleniumTest;

public class ClickUtils extends SeleniumTest{

	public static void clickButtonOrFail(By locator, String buttonName) {
		WebElement element = driver.findElement(locator);

		if(element != null && element.isDisplayed()) {
			element.click();
			imagePath = takeScreenShot();
			imageFolderPath = test.addScreenCapture(imagePath);
			test.log(LogStatus.PASS, "Clicked on the " + buttonName + " button", imageFolderPath);
			
		}
		else {
			imagePath = takeScreenShot();
			imageFolderPath = test.addScreenCapture(imagePath);
			test.log(LogStatus.FAIL, buttonName = " button is not present", imageFolderPath);
		}
	}
}
