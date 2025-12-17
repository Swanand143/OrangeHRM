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

	public WebElement getMyInfoMenu() {
		return myInfoMenu;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
}
