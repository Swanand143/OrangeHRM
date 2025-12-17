package com.crm.BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.POM.Admin;
import com.crm.POM.Dashboard;

public class AdminBase extends LoginAction {

	protected Admin admin;
	protected Dashboard dash;

	public void openAdminModule() throws IOException {

		login();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[text()='Admin']")));

		dash = new Dashboard(driver);
		dash.getAdminMenu().click();

		admin = new Admin(driver);
	}
}
