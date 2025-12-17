package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//p[text()='Forgot your password? ']")
	private WebElement forgotPasswordLink;

	@FindBy(xpath = "//div[contains(@class,'orangehrm-login-branding')]")
	private WebElement logo;

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement usernamePlaceholder;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passwordPlaceholder;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getForgotPassword() {
		return forgotPasswordLink;
	}

	public WebElement getLogo() {
		return logo;
	}

	public WebElement getUsernamePlaceholder() {
		return usernamePlaceholder;
	}

	public WebElement getPasswordPlaceholder() {
		return passwordPlaceholder;
	}
}
