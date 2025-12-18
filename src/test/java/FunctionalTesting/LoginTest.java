package FunctionalTesting;

import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.LoginAction;
import com.crm.FileUtility.ReadFromExcel;
import com.crm.POM.Login;

@Listeners(com.crm.Listeners.ExtentReportListeners.class)
public class LoginTest extends LoginAction {

	@Test
	public void tc_001() {
		Login log = new Login(driver);
		boolean output = log.getUsername().isEnabled();
		assertTrue(output, "username is disabled and defect is found");
	}

	@Test
	public void tc_002() throws Exception {
		String wrongUser = ReadFromExcel.readExcel(1, 0, "login");
		String wrongPass = ReadFromExcel.readExcel(1, 1, "login");

		Login log = new Login(driver);
		log.getUsername().sendKeys(wrongUser);
		log.getPassword().sendKeys(wrongPass);
		log.getLoginButton().click();

		List<WebElement> errorBox = driver.findElements(By.xpath("//div[contains(@class,'oxd-alert-content')]"));
		assertFalse(errorBox.isEmpty(), "login is successful defect is found");
	}

	@Test
	public void tc_003() {
		Login log = new Login(driver);
		assertTrue(log.getPassword().isDisplayed(), "password field not displayed");
	}

	@Test
	public void tc_004() {
		Login log = new Login(driver);
		assertTrue(log.getLoginButton().isEnabled(), "login button disabled");
	}

	@Test
	public void tc_005() {
		Login log = new Login(driver);
		assertTrue(log.getForgotPassword().isDisplayed(), "forgot password link missing");
	}

	@Test
	public void tc_006() {
		Login log = new Login(driver);
		log.getPassword().sendKeys("admin123");
		log.getLoginButton().click();
		assertTrue(driver.getPageSource().contains("Required"));
	}

	@Test
	public void tc_007() {
		Login log = new Login(driver);
		log.getUsername().sendKeys("Admin");
		log.getLoginButton().click();
		assertTrue(driver.getPageSource().contains("Required"));
	}

	@Test
	public void tc_008() throws Exception {
		String user = ReadFromExcel.readExcel(2, 0, "login");
		String pass = ReadFromExcel.readExcel(2, 1, "login");

		Login log = new Login(driver);
		log.getUsername().sendKeys(user);
		log.getPassword().sendKeys(pass);
		log.getLoginButton().click();

		assertTrue(driver.getPageSource().contains("Invalid"));
	}

	@Test
	public void tc_009() throws Exception {
		String user = ReadFromExcel.readExcel(3, 0, "login");
		String pass = ReadFromExcel.readExcel(3, 1, "login");

		Login log = new Login(driver);
		log.getUsername().sendKeys(user);
		log.getPassword().sendKeys(pass);
		log.getLoginButton().click();

		assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}

	@Test
	public void tc_010() {
		Login log = new Login(driver);
		assertTrue(log.getLogo().isDisplayed(), "logo not displayed");
	}
}
