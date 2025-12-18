package IntegrationTesting;

import static org.testng.Assert.assertTrue;

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
		boolean output = driver.getCurrentUrl().contains("myInfo");
		assertTrue(output, "Dashboard to MyInfo navigation failed And Defect is found");
	}
}
