package pages.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.Login;
import common.SeleniumTest;
import utils.ClickUtils;
import utils.FillUtils;

public class LoginPage extends SeleniumTest{
	
	private static By LOC_IN_USERNAME = By.id("txtUsername");
	private static By LOC_IN_PASSWORD = By.id("txtPassword");
	private static By LOC_BT_LOGIN_BUTTON = By.id("btnLogin");
	
	public void enterCredentials(String username, String password) {
		enterUsername(username);
		enterPassword(password);
	}
	
	private void enterUsername(String username) {
		FillUtils.fillInputOrFail(LOC_IN_USERNAME, username, "Username");
	}
	
	private void enterPassword(String password) {
		FillUtils.fillInputOrFail(LOC_IN_PASSWORD, password, "Password");
	}

	public void clickLogin() throws InterruptedException {
		ClickUtils.clickButtonOrFail(LOC_BT_LOGIN_BUTTON, "Login");
	}

}
