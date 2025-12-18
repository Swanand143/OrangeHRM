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
	
	// Verifies that the username input field is enabled and ready for user input.
	@Test
	public void tc_001() {
		Login log = new Login(driver);
		boolean output = log.getUsername().isEnabled();
		assertTrue(output, "username is disabled and defect is found");
	}
	
	// Verifies that the username input field is enabled and ready for user input.	
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
	
	// Checks visibility of the password field and validates the correct placeholder text.
	@Test
	public void tc_003() {
		Login log = new Login(driver);
		boolean passwordVisible = log.getPassword().isDisplayed();
		String placeholder = log.getPasswordPlaceholder().getAttribute("placeholder");
		boolean output = passwordVisible && placeholder.equalsIgnoreCase("Password");
		assertTrue(output, "Password field or placeholder incorrect And Defect is found");
	}
	
	// Verifies that the Login button is enabled and displays the correct button label.
	@Test
	public void tc_004() {		
		Login log = new Login(driver);
		boolean buttonEnabled = log.getLoginButton().isEnabled();
		String buttonText = log.getLoginButton().getText();
		boolean output = buttonEnabled && buttonText.equalsIgnoreCase("Login");
		assertTrue(output, "Login button state or text incorrect And Defect is found");
	}
	
	// Ensures the “Forgot Password” link is visible and contains correct text.
	@Test
	public void tc_005() {
		Login log = new Login(driver);
		boolean linkVisible = log.getForgotPassword().isDisplayed();
		String linkText = log.getForgotPassword().getText();
		boolean output = linkVisible && linkText.contains("Forgot");
		assertTrue(output, "Forgot password link incorrect And Defect is found");
	}

	// Tries login without entering username and validates mandatory field error message.
	@Test
	public void tc_006() {
		Login log = new Login(driver);
		log.getPassword().sendKeys("admin123");
		log.getLoginButton().click();
		assertTrue(driver.getPageSource().contains("Required"));
	}
	
	// Tries login without entering password and validates mandatory field error message.	
	@Test
	public void tc_007() {
		Login log = new Login(driver);
		log.getUsername().sendKeys("Admin");
		log.getLoginButton().click();
		assertTrue(driver.getPageSource().contains("Required"));
	}
	
	// Attempts login using invalid credentials from Excel and verifies error handling.		
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
	
	// Performs login with valid credentials from Excel and verifies successful navigation to dashboard.
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
	
	// Validates login page branding by checking logo visibility and correct page title.
	@Test
	public void tc_010() {
		Login log = new Login(driver);
		boolean logoVisible = log.getLogo().isDisplayed();
		String title = driver.getTitle();
		boolean output = logoVisible && title.contains("OrangeHRM");
		assertTrue(output, "Login page branding not loaded properly And Defect is found");
	}
}
