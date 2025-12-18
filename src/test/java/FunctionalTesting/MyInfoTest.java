package FunctionalTesting;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.MyInfoBase;

@Listeners(com.crm.Listeners.ExtentReportListeners.class)
public class MyInfoTest extends MyInfoBase {

	@BeforeMethod
	public void init() throws Exception {
		openMyInfoModule();
	}

	@Test
	public void tc_01() {
		myInfo.getMyInfoMenu().click();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		boolean output = url.contains("viewPersonalDetails") && title.contains("OrangeHRM");
		assertTrue(output, "My Info module not opened correctly And Defect is found");
	}

	@Test
	public void tc_02() {
		String header = myInfo.getPersonalDetailsHeader().getText();
		boolean headerVisible = header.equalsIgnoreCase("Personal Details");
		boolean saveEnabled = myInfo.getSaveButton().isEnabled();
		boolean output = headerVisible && saveEnabled;
		assertTrue(output, "Personal Details page not loaded properly And Defect is found");
	}

	@Test
	public void tc_03() {
		boolean firstNameEnabled = myInfo.getFirstNameField().isEnabled();
		boolean lastNameEnabled = myInfo.getLastNameField().isEnabled();
		String url = driver.getCurrentUrl();
		boolean output = firstNameEnabled && lastNameEnabled && url.contains("myInfo");
		assertTrue(output, "Employee name fields not editable And Defect is found");
	}

	@Test
	public void tc_04() {
		myInfo.getFirstNameField().clear();
		myInfo.getSaveButton().click();
		boolean errorPresent = driver.getPageSource().contains("Required");
		assertTrue(errorPresent, "Mandatory field validation missing And Defect is found");
	}

	@Test
	public void tc_05() {
		myInfo.getFirstNameField().sendKeys("TestUser");
		myInfo.getLastNameField().sendKeys("Automation");
		myInfo.getSaveButton().click();
		boolean successMsg = driver.getPageSource().contains("Successfully");
		assertTrue(successMsg, "Profile update failed And Defect is found");
	}

	@Test
	public void tc_06() {
		driver.navigate().refresh();
		boolean urlValid = driver.getCurrentUrl().contains("myInfo");
		boolean headerVisible = myInfo.getPersonalDetailsHeader().isDisplayed();
		boolean output = urlValid && headerVisible;
		assertTrue(output, "My Info page not stable after refresh And Defect is found");
	}

	@Test
	public void tc_07() {
		myInfo.getUserDropdown().click();
		boolean logoutVisible = myInfo.getLogout().isDisplayed();
		String title = driver.getTitle();
		boolean output = logoutVisible && title.contains("OrangeHRM");
		assertTrue(output, "User dropdown options not loaded And Defect is found");
	}

	@Test
	public void tc_08() {
		myInfo.getUserDropdown().click();
		myInfo.getLogout().click();
		String url = driver.getCurrentUrl();
		boolean output = url.contains("login");
		assertTrue(output, "Logout from My Info module failed And Defect is found");
	}		

	@Test
	public void tc_09() throws Exception {
		openMyInfoModule();
		String pageSource = driver.getPageSource();
		boolean output = pageSource.contains("Personal Details") && pageSource.contains("Employee");
		assertTrue(output, "Employee personal information missing And Defect is found");
	}

	@Test
	public void tc_10() {
		String title = driver.getTitle();
		String url = driver.getCurrentUrl();
		boolean output = title.contains("OrangeHRM") && !url.contains("login");
		assertTrue(output, "Session lost while accessing My Info module And Defect is found");
	}
}
