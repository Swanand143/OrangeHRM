package FunctionalTesting;

import org.testng.Assert;
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
		Assert.assertTrue(pim.getAddEmployeeButton().isDisplayed());
	}

	@Test
	public void tc_02() {
		pim.getAddEmployeeButton().click();
		Assert.assertTrue(pim.getFirstName().isDisplayed());
	}

	@Test
	public void tc_03() {
		pim.getAddEmployeeButton().click();
		Assert.assertTrue(pim.getLastName().isDisplayed());
	}

	@Test
	public void tc_04() {
		pim.getAddEmployeeButton().click();
		Assert.assertTrue(pim.getSaveButton().isEnabled());
	}

	@Test
	public void tc_05() throws Exception {
		pim.getAddEmployeeButton().click();
		pim.getFirstName().sendKeys(ReadFromExcel.readExcel(1, 0, "pim"));
		pim.getLastName().sendKeys(ReadFromExcel.readExcel(1, 1, "pim"));
		pim.getSaveButton().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"));
	}

	@Test
	public void tc_06() {
		Assert.assertTrue(pim.getEmployeeList().isDisplayed());
	}

	@Test
	public void tc_07() {
		pim.getEmployeeList().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("viewEmployeeList"));
	}

	@Test
	public void tc_08() {
		Assert.assertTrue(pim.getPimMenu().isDisplayed());
	}

	@Test
	public void tc_09() {
		pim.getPimMenu().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("pim"));
	}

	@Test
	public void tc_10() {
		Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
	}
}
