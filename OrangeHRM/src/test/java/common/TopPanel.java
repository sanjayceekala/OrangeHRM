package common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.WaitUtils;

public class TopPanel extends SeleniumTest{

	private static By LOC_WL_MENU_LIST = By.cssSelector("#mainMenuFirstLevelUnorderedList>li>a");
	private static By LOC_WL_SUBMENU_LIST = By.xpath(".//*[@class='selected']/parent::ul//a");

	public enum Menu{

		Admim("Admin"),
		PIM("PIM"),
		Leave("Leave");

		private String text;
		private Menu(String text) {
			this.text = text;
		}

		public String getText() {
			return this.text;
		}	

	}

	public enum subMenu{

		UserManagement("User Management"),
		Job("Job");

		private String text;
		private subMenu(String text) {
			this.text = text;
		}

		public String getText() {
			return this.text;
		}
	}

	public enum subMenuOption{
		Users("Users"),
		JobTitles("Job Titles");

		private String text;
		private subMenuOption(String text) {
			this.text = text;
		}

		public String getText() {
			return this.text;
		}

	}

	/**
	 * To select the menu, submenu and the desited option
	 * @param menuOption
	 * @param subMenu
	 * @param subMenuOption
	 */

	public void selectMenuSubMenuOption(Menu menuOption, subMenu subMenu,subMenuOption subMenuOption) {
		selectMenu(menuOption);
		selectSubMenu(subMenu, subMenuOption);
		selectOptionSubMenu(subMenuOption);
	}

	/**
	 * Select the Menu Option
	 * @param menuOption
	 */

	public void selectMenu(Menu menuOption) {
		WaitUtils.waitForElementVisible(LOC_WL_MENU_LIST, menuOption.getText(), 3);
		List<WebElement> menuList = driver.findElements(LOC_WL_MENU_LIST);
		for(WebElement menu : menuList) {
			if(menu.getText().equals(menuOption.getText())) {
				menu.click();
				break;
			}
		}
	}

	/**
	 * Select the subMenu option
	 * @param menuOption
	 */

	public void selectSubMenu(subMenu subMenu, subMenuOption subMenuOption) {
		WaitUtils.waitForElementVisible(LOC_WL_SUBMENU_LIST, subMenuOption.getText(), 3);
		List<WebElement> menuList = driver.findElements(LOC_WL_SUBMENU_LIST);
		for(WebElement menu : menuList) {
			if(menu.getText().equals(subMenu.getText())) {
				menu.click();
				break;
			}
		}
	}

	/**
	 * To select the option after clicking on the desired submenu option
	 * @param option
	 */

	public void selectOptionSubMenu(subMenuOption subMenuOption) {
		WaitUtils.waitForElementVisible(LOC_WL_SUBMENU_LIST, subMenuOption.getText(), 3);
		List<WebElement> options = driver.findElements(LOC_WL_SUBMENU_LIST);
		for(WebElement option : options) {
			if(option.getText().equals(subMenuOption.getText())) {
				option.click();
				break;
			}
		}
	}

}
