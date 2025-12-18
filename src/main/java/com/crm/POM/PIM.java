package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIM {

	public PIM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement pimMenu;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement addEmployeeButton;

	@FindBy(name = "firstName")
	private WebElement firstName;

	@FindBy(name = "lastName")
	private WebElement lastName;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//a[text()='Employee List']")
	private WebElement employeeList;

	@FindBy(xpath = "//h6[text()='Add Employee']")
	private WebElement addEmployeeHeader;

	@FindBy(xpath = "//h6[text()='Employee Information']")
	private WebElement employeeInfoHeader;

	@FindBy(xpath = "//div[contains(@class,'oxd-table')]")
	private WebElement employeeTable;

	public WebElement getPimMenu() {
		return pimMenu;
	}

	public WebElement getAddEmployeeButton() {
		return addEmployeeButton;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getEmployeeList() {
		return employeeList;
	}

	public WebElement getAddEmployeeHeader() {
		return addEmployeeHeader;
	}

	public WebElement getEmployeeInfoHeader() {
		return employeeInfoHeader;
	}

	public WebElement getEmployeeTable() {
		return employeeTable;
	}
}
