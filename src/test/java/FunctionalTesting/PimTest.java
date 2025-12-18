package FunctionalTesting;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.PimBase;
import com.crm.FileUtility.ReadFromExcel;

@Listeners(com.crm.Listeners.ExtentReportListeners.class)
public class PimTest extends PimBase {

	@BeforeMethod
	public void init() throws Exception {
		openPimModule();
	}
	
	// Navigates to the PIM module and verifies that the correct page is loaded using URL and title validation.
	@Test
	public void tc_01() {
		pim.getPimMenu().click();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		boolean output = url.contains("pim") && title.contains("OrangeHRM");
		assertTrue(output, "PIM module not loaded correctly And Defect is found");
	}
	
	// Opens the Add Employee page and checks whether the page header and First Name field are available.
	@Test
	public void tc_02() {
		pim.getAddEmployeeButton().click();
		String header = pim.getAddEmployeeHeader().getText();
		boolean firstNameEnabled = pim.getFirstName().isEnabled();
		boolean output = header.equals("Add Employee") && firstNameEnabled;
		assertTrue(output, "Add Employee page not opened properly And Defect is found");
	}
	
	// Attempts to save employee details without entering data to verify mandatory field validation.
	@Test
	public void tc_03() {
		pim.getAddEmployeeButton().click();
		pim.getSaveButton().click();
		boolean validationMsg = driver.getPageSource().contains("Required");
		assertTrue(validationMsg, "Mandatory field validation missing And Defect is found");
	}
	
	// Creates a new employee using valid data from Excel and verifies successful navigation to employee details page.
	@Test
	public void tc_04() throws Exception {
		pim.getAddEmployeeButton().click();
		pim.getFirstName().sendKeys(ReadFromExcel.readExcel(1, 0, "pim"));
		pim.getLastName().sendKeys(ReadFromExcel.readExcel(1, 1, "pim"));
		pim.getSaveButton().click();
		boolean output = driver.getCurrentUrl().contains("viewPersonalDetails");
		assertTrue(output, "Employee creation failed And Defect is found");
	}
	
	// Confirms that the Employee Information page is displayed after employee creation.
	@Test
	public void tc_05() {
		String header = pim.getEmployeeInfoHeader().getText();
		boolean output = header.equalsIgnoreCase("Employee Information");
		assertTrue(output, "Employee information page not loaded And Defect is found");
	}
	
	// Opens the Employee List page and validates that the employee table is displayed correctly.
	@Test
	public void tc_06() {
		pim.getEmployeeList().click();
		boolean tableVisible = pim.getEmployeeTable().isDisplayed();
		boolean urlCorrect = driver.getCurrentUrl().contains("viewEmployeeList");
		boolean output = tableVisible && urlCorrect;
		assertTrue(output, "Employee list not displayed correctly And Defect is found");
	}
	
	// Refreshes the PIM page and verifies that the module remains stable after reload.
	@Test
	public void tc_07() {
		driver.navigate().refresh();
		boolean urlValid = driver.getCurrentUrl().contains("pim");
		boolean menuVisible = pim.getPimMenu().isDisplayed();
		boolean output = urlValid && menuVisible;
		assertTrue(output, "PIM page unstable after refresh And Defect is found");
	}
	
	// Validates last name field by attempting to save employee details with missing mandatory data.
	@Test
	public void tc_08() {
		pim.getAddEmployeeButton().click();
		pim.getFirstName().sendKeys("Test");
		pim.getLastName().clear();
		pim.getSaveButton().click();
		boolean output = driver.getPageSource().contains("Required");
		assertTrue(output, "Last name validation missing And Defect is found");
	}
	
	// Verifies that PIM-related content is present on the page, ensuring correct module context.
	@Test
	public void tc_09() {
		String pageSource = driver.getPageSource();
		boolean output = pageSource.contains("Employee") && pageSource.contains("PIM");
		assertTrue(output, "PIM related content missing And Defect is found");
	}
	
	// Confirms that the user session remains active while working in the PIM module.
	@Test
	public void tc_10() {
		String url = driver.getCurrentUrl();
		boolean output = !url.contains("login") && url.contains("pim");
		assertTrue(output, "Unexpected logout from PIM module And Defect is found");
	}
}
