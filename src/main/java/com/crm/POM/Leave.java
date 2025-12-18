package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Leave {

	public Leave(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Leave']")
	private WebElement leaveMenu;

	@FindBy(xpath = "//h6[text()='Leave']")
	private WebElement leaveHeader;

	@FindBy(xpath = "//a[text()='Apply']")
	private WebElement applyLeave;

	@FindBy(xpath = "//a[text()='Leave List']")
	private WebElement leaveList;

	@FindBy(xpath = "//a[text()='Assign Leave']")
	private WebElement assignLeave;

	@FindBy(xpath = "//div[@class='oxd-layout-context']")
	private WebElement leaveContainer;

	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']")
	private WebElement breadcrumb;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	private WebElement searchButton;

	public WebElement getLeaveMenu() {
		return leaveMenu;
	}

	public WebElement getLeaveHeader() {
		return leaveHeader;
	}

	public WebElement getApplyLeave() {
		return applyLeave;
	}

	public WebElement getLeaveList() {
		return leaveList;
	}

	public WebElement getAssignLeave() {
		return assignLeave;
	}

	public WebElement getLeaveContainer() {
		return leaveContainer;
	}

	public WebElement getBreadcrumb() {
		return breadcrumb;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
}
