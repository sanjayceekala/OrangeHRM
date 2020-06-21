package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import common.SeleniumTest;

public class ClickUtils extends SeleniumTest{

	public static void clickButtonOrFail(By locator, String buttonName) {
		WebElement element = driver.findElement(locator);

		if(element != null && element.isDisplayed()) {
			element.click();
			ReportManager.reportPassed("Clicked on the " + buttonName + " button");
		}
		else {
			ReportManager.reportFailed(buttonName + " button is not present");
		}
	}
}
