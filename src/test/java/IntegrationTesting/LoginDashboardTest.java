package IntegrationTesting;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.DashboardBase;

@Listeners(com.crm.Listeners.ExtentReportListeners.class)
public class LoginDashboardTest extends DashboardBase {

	@BeforeMethod
	public void init() throws Exception {
		openDashboard();
	}

	@Test
	public void tc_01() {
		Assert.assertTrue(dash.getAdminMenu().isDisplayed());
	}
}
