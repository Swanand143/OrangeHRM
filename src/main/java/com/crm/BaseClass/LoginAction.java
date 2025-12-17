package com.crm.BaseClass;

import java.io.IOException;

import com.crm.POM.Login;

public class LoginAction extends BaseClass {

	public void login() throws IOException {

		Login login = new Login(driver);

		String username = propertiesFile("username");
		String password = propertiesFile("password");

		login.getUsername().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.getLoginButton().click();
	}
}
