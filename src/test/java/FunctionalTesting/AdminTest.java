package FunctionalTesting;

import org.testng.Assert;
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


	@Test
	public void tc_01() {
		Assert.assertTrue(admin.getAdminMenu().isDisplayed());
	}

	@Test
	public void tc_02() {
		Assert.assertTrue(admin.getAddButton().isDisplayed());
	}

	@Test
	public void tc_03() {
		Assert.assertTrue(admin.getSearchButton().isDisplayed());
	}

	@Test
	public void tc_04() {
		Assert.assertTrue(admin.getResetButton().isDisplayed());
	}

	@Test
	public void tc_05() {
		admin.getAddButton().click();
		Assert.assertTrue(admin.getSaveButton().isDisplayed());
	}

	@Test
	public void tc_06() throws Exception {
		String username = ReadFromExcel.readExcel(1, 0, "admin");
		admin.getUsernameField().sendKeys(username);
		admin.getSearchButton().click();
		Assert.assertTrue(driver.getPageSource().contains(username));
	}

	@Test
	public void tc_07() throws Exception {
		String username = ReadFromExcel.readExcel(2, 0, "admin");
		admin.getUsernameField().sendKeys(username);
		admin.getSearchButton().click();
		Assert.assertTrue(driver.getPageSource().contains("No Records Found"));
	}

	@Test
	public void tc_08() {
		admin.getResetButton().click();
		Assert.assertEquals(admin.getUsernameField().getAttribute("value"), "");
	}

	@Test
	public void tc_09() {
		admin.getAddButton().click();
		admin.getSaveButton().click();
		Assert.assertTrue(driver.getPageSource().contains("Required"));
	}

	@Test
	public void tc_10() {
		Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
	}
}
