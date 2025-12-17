package IntegrationTesting;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.AdminBase;

@Listeners(com.crm.Listeners.ExtentReportListeners.class)
public class DashboardAdminTest extends AdminBase {

	@BeforeMethod
	public void init() throws Exception {
		openAdminModule();
	}

	@Test
	public void tc_01() {
		Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
	}
}
