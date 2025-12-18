package FunctionalTesting;

import static org.testng.Assert.assertTrue;

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
		String header = dash.getDashboardHeader().getText();
		boolean output = header.equalsIgnoreCase("Dashboard");
		assertTrue(output, "Dashboard header not visible And Defect is found");
	}

	@Test
	public void tc_02() {
		boolean output = dash.getDashboardContainer().isDisplayed();
		assertTrue(output, "Dashboard main container not loaded And Defect is found");
	}

	@Test
	public void tc_03() {
		dash.getAdminMenu().click();
		String url = driver.getCurrentUrl();
		boolean output = url.contains("admin");
		assertTrue(output, "Admin module not opened And Defect is found");
	}

	@Test
	public void tc_04() {
		dash.getPimMenu().click();
		String breadcrumb = dash.getBreadcrumb().getText();
		boolean output = breadcrumb.contains("PIM");
		assertTrue(output, "PIM breadcrumb not updated And Defect is found");
	}

	@Test
	public void tc_05() {
		dash.getLeaveMenu().click();
		String url = driver.getCurrentUrl();
		boolean output = url.contains("leave");
		assertTrue(output, "Leave module navigation failed And Defect is found");
	}

	@Test
	public void tc_06() {
		dash.getMyInfoMenu().click();
		String url = driver.getCurrentUrl();
		boolean output = url.contains("viewPersonalDetails");
		assertTrue(output, "My Info module not opened And Defect is found");
	}

	@Test
	public void tc_07() {
		dash.getUserdropdown_icon().click();
		boolean output = dash.getLogout().isDisplayed();
		assertTrue(output, "Logout option not visible And Defect is found");
	}

	@Test
	public void tc_08() {
		dash.getUserdropdown_icon().click();
		dash.getLogout().click();
		String url = driver.getCurrentUrl();
		boolean output = url.contains("login");
		assertTrue(output, "Logout functionality failed And Defect is found");
	}

	@Test
	public void tc_09() {
		dash.getAdminMenu().click();
		dash.getPimMenu().click();
		String url = driver.getCurrentUrl();
		boolean output = url.contains("pim");
		assertTrue(output, "Dashboard menu navigation failed And Defect is found");
	}

	@Test
	public void tc_10() {
		String title = driver.getTitle();
		boolean output = title.contains("OrangeHRM");
		assertTrue(output, "Dashboard page title incorrect And Defect is found");
	}
}
