package IntegrationTesting;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.LeaveBase;

@Listeners(com.crm.Listeners.ExtentReportListeners.class)
public class DashboardLeaveTest extends LeaveBase {

	@BeforeMethod
	public void init() throws Exception {
		openLeaveModule();
	}

	@Test
	public void tc_01() {
		boolean output = driver.getCurrentUrl().contains("leave");
		assertTrue(output, "Dashboard to Leave navigation failed And Defect is found");
	}
}
