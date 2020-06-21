package pages.admin;

import org.openqa.selenium.By;

import utils.ClickUtils;
import utils.FillUtils;
import utils.WaitUtils;

public class UsernameManagement {
	
	private static By LOC_BT_ADD_BUTTON = By.cssSelector("#btnAdd");
	private static By LOC_DD_USER_ROLE = By.cssSelector("#frmSystemUser select[name*=userType]");
	private static By LOC_IN_EMPLOYEE_NAME = By.cssSelector("#frmSystemUser input[name*=employeeName]");
	private static By LOC_IN_USER_NAME = By.cssSelector("#frmSystemUser input[name*=userName]");
	private static By LOC_DD_STATUS = By.cssSelector("#frmSystemUser select[name*=status]");
	private static By LOC_IN_PASSWORD = By.cssSelector("#frmSystemUser input[name*=password]");
	private static By LOC_IN_CONFIRM_PASSWORD = By.cssSelector("#frmSystemUser input[name*=confirmPassword]");
	private static By LOC_BT_SAVE_BUTTON = By.cssSelector("#btnSave");
	

	public enum UserManagementConstants{
		UserRoleAdmin("Admin"),
		UserRoleESS("ESS"),
		StatusEnabled("Enabled"),
		StatusDisabled("Enabled");

		private String text;
		private UserManagementConstants(String text) {
			this.text = text;
		}

		public String getText() {
			return this.text;
		}
	}
	
	/**
	 * To add the user
	 * @param userRole
	 * @param empName
	 * @param uName
	 * @param status
	 * @param password
	 */
	
	public void addUser(UserManagementConstants userRole, String empName, String uName, UserManagementConstants status, String password) {
		
		clickAddButtonAddUser();
		fillDetailsAddUser(userRole, empName, uName, status, password);
		clickSaveAddUser();
	}
	
	public void clickAddButtonAddUser() {
		ClickUtils.clickButtonOrFail(LOC_BT_ADD_BUTTON, "Add");
	}
	
	/**
	 * To fill the details for the user to add
	 * @param userRole
	 * @param empName
	 * @param uName
	 * @param status
	 * @param password
	 */
	
	public void fillDetailsAddUser(UserManagementConstants userRole, String empName, String uName, UserManagementConstants status, String password) {
		WaitUtils.waitForElementPresent(LOC_IN_USER_NAME, "Username", 5);
		FillUtils.fillSelectByVisibleText(LOC_DD_USER_ROLE, userRole.getText(), "User role");
		FillUtils.fillInputOrFail(LOC_IN_EMPLOYEE_NAME, empName, "Employee name");
		FillUtils.fillInputOrFail(LOC_IN_USER_NAME, uName, "Username");
		FillUtils.fillSelectByVisibleText(LOC_DD_STATUS, status.getText(), "Status");
		FillUtils.fillInputOrFail(LOC_IN_PASSWORD, password, "Password");
		FillUtils.fillInputOrFail(LOC_IN_CONFIRM_PASSWORD, password, "Confirm Password");
		
	}
	
	/**
	 * To click on the Save button in Add user screen
	 */
	
	public void clickSaveAddUser() {
		WaitUtils.waitForElementPresent(LOC_BT_SAVE_BUTTON, "Save button" , 5);
		ClickUtils.clickButtonOrFail(LOC_BT_SAVE_BUTTON, "Save");
	}

}

