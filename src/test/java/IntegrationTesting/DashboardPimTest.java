package IntegrationTesting;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.PimBase;

@Listeners(com.crm.Listeners.ExtentReportListeners.class)
public class DashboardPimTest extends PimBase {

	@BeforeMethod
	public void init() throws Exception {
		openPimModule();
	}

	@Test
	public void tc_01() {
		Assert.assertTrue(driver.getCurrentUrl().contains("pim"));
	}
}
