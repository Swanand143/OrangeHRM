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

	@FindBy(xpath = "//a[text()='Apply']")
	private WebElement applyLeave;

	@FindBy(xpath = "//a[text()='Leave List']")
	private WebElement leaveList;

	@FindBy(xpath = "//a[text()='Assign Leave']")
	private WebElement assignLeave;

	public WebElement getLeaveMenu() {
		return leaveMenu;
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
}
