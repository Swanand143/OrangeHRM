package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

	public Dashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	private WebElement userDropdownIcon;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logout;
	
	@FindBy(xpath = "//span[text()='Admin']")
	private WebElement adminMenu;

	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement pimMenu;

	@FindBy(xpath = "//span[text()='Leave']")
	private WebElement leaveMenu;

	@FindBy(xpath = "//span[text()='My Info']")
	private WebElement myInfoMenu;

	@FindBy(xpath = "//h6[text()='Dashboard']")
	private WebElement dashboardHeader;

	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']")
	private WebElement breadcrumb;

	@FindBy(xpath = "//div[contains(@class,'oxd-layout-context')]")
	private WebElement dashboardContainer;

	public WebElement getUserdropdown_icon() {
		return userDropdownIcon;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getAdminMenu() {
		return adminMenu;
	}

	public WebElement getPimMenu() {
		return pimMenu;
	}

	public WebElement getLeaveMenu() {
		return leaveMenu;
	}

	public WebElement getMyInfoMenu() {
		return myInfoMenu;
	}

	public WebElement getDashboardHeader() {
		return dashboardHeader;
	}

	public WebElement getBreadcrumb() {
		return breadcrumb;
	}

	public WebElement getDashboardContainer() {
		return dashboardContainer;
	}
}
