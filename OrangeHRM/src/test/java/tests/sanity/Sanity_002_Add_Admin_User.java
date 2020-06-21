package tests.sanity;

import org.testng.annotations.Test;

import common.CommonPage;
import common.TopPanel;
import common.TopPanel.Menu;
import common.TopPanel.subMenu;
import common.TopPanel.subMenuOption;
import pages.admin.UsernameManagement;
import pages.admin.UsernameManagement.UserManagementConstants;
import pages.loginPage.LoginPage;

public class Sanity_002_Add_Admin_User extends CommonPage{
	
	@Test
	public void Sanity_002_Add_Admin_User_Test() throws Exception{
		
		testName = "Sanity_002_Add_Admin_User_Test";
		LoginPage login = new LoginPage();
		login.enterCredentials("admin", "admin123");
		login.clickLogin();
		
		TopPanel topPanel = new TopPanel();
		topPanel.selectMenuSubMenuOption(Menu.Admim, subMenu.UserManagement, subMenuOption.Users);
		
		UsernameManagement user = new UsernameManagement();
		user.addUser(UserManagementConstants.UserRoleAdmin, "Sanjay Ceekala", "Sanjay2", UserManagementConstants.StatusEnabled, "sanjay@89");
		
	}
	
}
