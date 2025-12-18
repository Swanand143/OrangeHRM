package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfo {

	public MyInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='My Info']")
	private WebElement myInfoMenu;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//h6[text()='Personal Details']")
	private WebElement personalDetailsHeader;

	@FindBy(name = "firstName")
	private WebElement firstNameField;

	@FindBy(name = "lastName")
	private WebElement lastNameField;

	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	private WebElement userDropdown;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logout;

	public WebElement getMyInfoMenu() {
		return myInfoMenu;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getPersonalDetailsHeader() {
		return personalDetailsHeader;
	}

	public WebElement getFirstNameField() {
		return firstNameField;
	}

	public WebElement getLastNameField() {
		return lastNameField;
	}

	public WebElement getUserDropdown() {
		return userDropdown;
	}

	public WebElement getLogout() {
		return logout;
	}
}
