package IntegrationTesting;

import static org.testng.Assert.assertTrue;

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
		boolean output = driver.getCurrentUrl().contains("admin");
		assertTrue(output, "Dashboard to Admin navigation failed And Defect is found");
	}
}
