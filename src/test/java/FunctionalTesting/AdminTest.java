package FunctionalTesting;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.AdminBase;
import com.crm.FileUtility.ReadFromExcel;
import com.crm.POM.Admin;

@Listeners(com.crm.Listeners.ExtentReportListeners.class)
public class AdminTest extends AdminBase {

	private Admin admin;

	@BeforeMethod
	public void init() throws Exception {
		openAdminModule();
		admin = new Admin(driver);
	}
	
	// Verifies that the Admin page is opened successfully by checking the page header text.
	@Test
	public void tc_01() {
		String header = admin.getAdminHeader().getText();
		boolean output = header.equalsIgnoreCase("Admin");
		assertTrue(output, "Admin page header not loaded And Defect is found");
	}
	
	// Searches for a valid admin username and confirms that the result table is displayed.
	@Test
	public void tc_02() throws Exception {
		String username = ReadFromExcel.readExcel(1, 0, "admin");
		admin.getUsernameField().sendKeys(username);
		admin.getSearchButton().click();
		boolean output = admin.getResultTable().isDisplayed();
		assertTrue(output, "Search result not displayed And Defect is found");
	}
	
	// Searches with an invalid username and validates that the system shows “No Records Found”.	
	@Test
	public void tc_03() throws Exception {
		String username = ReadFromExcel.readExcel(2, 0, "admin");
		admin.getUsernameField().sendKeys(username);
		admin.getSearchButton().click();
		String text = admin.getRecordCountText().getText();
		boolean output = text.contains("No Records Found");
		assertTrue(output, "Invalid user search not handled And Defect is found");
	}
	
	// Clicks on the Add button and checks whether the Add User page is opened properly.	
	@Test
	public void tc_04() {
		admin.getAddButton().click();
		boolean output = admin.getSaveButton().isDisplayed();
		assertTrue(output, "Add user page not opened And Defect is found");
	}
	
	// Attempts to save a new admin user without entering mandatory fields and verifies validation messages.
	@Test
	public void tc_05() {
		admin.getAddButton().click();
		admin.getSaveButton().click();
		String pageSource = driver.getPageSource();
		boolean output = pageSource.contains("Required");
		assertTrue(output, "Mandatory field validation missing And Defect is found");
	}
	
	// Enters data in the username field, clicks Reset, and ensures the field is cleared.
	@Test
	public void tc_06() throws Exception {
		admin.getUsernameField().sendKeys("Admin");
		admin.getResetButton().click();
		String value = admin.getUsernameField().getAttribute("value");
		boolean output = value.isEmpty();
		assertTrue(output, "Reset button not clearing data And Defect is found");
	}
    
	// Performs a search without filters and verifies that default admin records are loaded.
	@Test
	public void tc_07() {
		admin.getSearchButton().click();
		boolean tableVisible = admin.getResultTable().isDisplayed();
		String recordText = admin.getRecordCountText().getText();
		boolean output = tableVisible && recordText.length() > 0;
		assertTrue(output, "Default admin records not loaded And Defect is found");
	}
	
	// Confirms that the Admin module is correctly loaded by validating both header text and URL.
	@Test
	public void tc_08() {
		String header = admin.getAdminHeader().getText();
		String url = driver.getCurrentUrl();
		boolean output = header.equalsIgnoreCase("Admin") && url.contains("admin");
		assertTrue(output, "Admin module page not loaded correctly And Defect is found");
	}
	
	// Confirms that the Admin module is correctly loaded by validating both header text and URL.
	@Test	
	public void tc_09() {
		admin.getAddButton().click();
		boolean saveVisible = admin.getSaveButton().isDisplayed();
		String url = driver.getCurrentUrl();
		boolean output = saveVisible && url.contains("save");
		assertTrue(output, "Add user page not opened correctly And Defect is found");
	}
	
	// Verifies that Search and Reset buttons are enabled and ready for user interaction.
	@Test
	public void tc_10() {
		boolean searchEnabled = admin.getSearchButton().isEnabled();
		boolean resetEnabled = admin.getResetButton().isEnabled();
		boolean output = searchEnabled && resetEnabled;
		assertTrue(output, "Search or Reset functionality not enabled And Defect is found");
	}

}
