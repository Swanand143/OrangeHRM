package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin {

	public Admin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Admin']")
	private WebElement adminMenu;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement addButton;

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement usernameField;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	private WebElement searchButton;

	@FindBy(xpath = "//button[normalize-space()='Reset']")
	private WebElement resetButton;

	public WebElement getAdminMenu() {
		return adminMenu;
	}

	public WebElement getAddButton() {
		return addButton;
	}

	public WebElement getUsernameField() {
		return usernameField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getResetButton() {
		return resetButton;
	}
}
