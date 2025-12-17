package IntegrationTesting;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.MyInfoBase;

@Listeners(com.crm.Listeners.ExtentReportListeners.class)
public class DashboardMyInfoTest extends MyInfoBase {

	@BeforeMethod
	public void init() throws Exception {
		openMyInfoModule();
	}

	@Test
	public void tc_01() {
		Assert.assertTrue(driver.getCurrentUrl().contains("myInfo"));
	}
}
