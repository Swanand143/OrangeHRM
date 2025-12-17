package FunctionalTesting;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.DashboardBase;

@Listeners(com.crm.Listeners.ExtentReportListeners.class)
public class DashboardTest extends DashboardBase {

	@BeforeMethod
	public void init() throws Exception {
		openDashboard();
	}

	@Test
	public void tc_01() {
		Assert.assertTrue(dash.getAdminMenu().isDisplayed());
	}

	@Test
	public void tc_02() {
		Assert.assertTrue(dash.getPimMenu().isDisplayed());
	}

	@Test
	public void tc_03() {
		Assert.assertTrue(dash.getLeaveMenu().isDisplayed());
	}

	@Test
	public void tc_04() {
		Assert.assertTrue(dash.getMyInfoMenu().isDisplayed());
	}

	@Test
	public void tc_05() {
		Assert.assertTrue(dash.getUserdropdown_icon().isDisplayed());
	}

	@Test
	public void tc_06() {
		dash.getUserdropdown_icon().click();
		Assert.assertTrue(dash.getLogout().isDisplayed());
	}

	@Test
	public void tc_07() {
		dash.getAdminMenu().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
	}

	@Test
	public void tc_08() {
		dash.getPimMenu().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("pim"));
	}

	@Test
	public void tc_09() {
		dash.getLeaveMenu().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("leave"));
	}

	@Test
	public void tc_10() {
		dash.getMyInfoMenu().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"));
	}
}
