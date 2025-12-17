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
}
