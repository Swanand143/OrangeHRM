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

	@Test
	public void tc_01() {
		boolean output = pim.getAddEmployeeButton().isDisplayed();
		assertTrue(output, "Add Employee button not displayed And Defect is found");
	}

	@Test
	public void tc_02() {
		pim.getAddEmployeeButton().click();
		boolean output = pim.getFirstName().isDisplayed();
		assertTrue(output, "First Name field not displayed And Defect is found");
	}

	@Test
	public void tc_03() {
		pim.getAddEmployeeButton().click();
		boolean output = pim.getSaveButton().isEnabled();
		assertTrue(output, "Save button is disabled And Defect is found");
	}

	@Test
	public void tc_04() {
		boolean output = driver.getCurrentUrl().contains("pim");
		assertTrue(output, "PIM module URL not loaded And Defect is found");
	}

	@Test
	public void tc_05() throws Exception {
		pim.getAddEmployeeButton().click();
		pim.getFirstName().sendKeys(ReadFromExcel.readExcel(1, 0, "pim"));
		pim.getLastName().sendKeys(ReadFromExcel.readExcel(1, 1, "pim"));
		pim.getSaveButton().click();
		boolean output = driver.getCurrentUrl().contains("viewPersonalDetails");
		assertTrue(output, "Employee creation failed And Defect is found");
	}

	@Test
	public void tc_06() {
		boolean output = driver.getPageSource().contains("Employee List");
		assertTrue(output, "Employee List text not found And Defect is found");
	}

	@Test
	public void tc_07() {
		pim.getEmployeeList().click();
		boolean output = driver.getCurrentUrl().contains("viewEmployeeList");
		assertTrue(output, "Employee List page not opened And Defect is found");
	}

	@Test
	public void tc_08() {
		driver.navigate().refresh();
		boolean output = driver.getCurrentUrl().contains("pim");
		assertTrue(output, "PIM page refresh failed And Defect is found");
	}

	@Test
	public void tc_09() {
		boolean output = driver.getTitle().contains("OrangeHRM");
		assertTrue(output, "PIM page title mismatch And Defect is found");
	}

	@Test
	public void tc_10() {
		boolean output = !driver.getCurrentUrl().contains("login");
		assertTrue(output, "Unexpected logout from PIM module And Defect is found");
	}
}
