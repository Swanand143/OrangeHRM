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
		boolean output = myInfo.getMyInfoMenu().isDisplayed();
		assertTrue(output, "My Info menu not displayed And Defect is found");
	}

	@Test
	public void tc_02() {
		boolean output = myInfo.getSaveButton().isDisplayed();
		assertTrue(output, "Save button not displayed And Defect is found");
	}

	@Test
	public void tc_03() {
		boolean output = myInfo.getSaveButton().isEnabled();
		assertTrue(output, "Save button is disabled And Defect is found");
	}

	@Test
	public void tc_04() {
		boolean output = driver.getCurrentUrl().contains("viewPersonalDetails");
		assertTrue(output, "My Info page URL mismatch And Defect is found");
	}

	@Test
	public void tc_05() {
		boolean output = driver.getTitle().contains("OrangeHRM");
		assertTrue(output, "My Info page title incorrect And Defect is found");
	}

	@Test
	public void tc_06() {
		boolean output = driver.getPageSource().contains("Personal Details");
		assertTrue(output, "Personal Details section missing And Defect is found");
	}

	@Test
	public void tc_07() {
		boolean output = driver.getPageSource().contains("Employee");
		assertTrue(output, "Employee information missing And Defect is found");
	}

	@Test
	public void tc_08() {
		myInfo.getSaveButton().click();
		boolean output = driver.getPageSource().contains("Successfully");
		assertTrue(output, "Save action failed And Defect is found");
	}

	@Test
	public void tc_09() {
		driver.navigate().refresh();
		boolean output = driver.getCurrentUrl().contains("myInfo");
		assertTrue(output, "My Info page refresh failed And Defect is found");
	}

	@Test
	public void tc_10() {
		boolean output = !driver.getCurrentUrl().contains("login");
		assertTrue(output, "Unexpected logout from My Info module And Defect is found");
	}
}
