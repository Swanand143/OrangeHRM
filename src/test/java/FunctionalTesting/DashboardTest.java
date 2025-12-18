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
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		boolean headerValid = header.equalsIgnoreCase("Dashboard");
		boolean pageValid = url.contains("dashboard") && title.contains("OrangeHRM");
		boolean output = headerValid && pageValid;
		assertTrue(output, "Dashboard page not loaded correctly And Defect is found");
	}


	@Test
	public void tc_02() {
		boolean containerVisible = dash.getDashboardContainer().isDisplayed();
		String breadcrumb = dash.getBreadcrumb().getText();
		String title = driver.getTitle();
		boolean breadcrumbValid = breadcrumb.contains("Dashboard");
		boolean output = containerVisible && breadcrumbValid && title.contains("OrangeHRM");
		assertTrue(output, "Dashboard UI or breadcrumb incorrect And Defect is found");
	}

	@Test
	public void tc_03() {
		dash.getAdminMenu().click();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		boolean urlValid = url.contains("admin");
		boolean titleValid = title.contains("OrangeHRM");
		boolean output = urlValid && titleValid;
		assertTrue(output, "Admin module navigation failed And Defect is found");
	}

	@Test
	public void tc_04() {
		dash.getPimMenu().click();
		String breadcrumb = dash.getBreadcrumb().getText();
		String url = driver.getCurrentUrl();
		boolean breadcrumbValid = breadcrumb.contains("PIM");
		boolean urlValid = url.contains("pim");
		boolean output = breadcrumbValid && urlValid;
		assertTrue(output, "PIM module breadcrumb or URL incorrect And Defect is found");
	}
		
	@Test
	public void tc_05() {
		dash.getLeaveMenu().click();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		boolean urlValid = url.contains("leave");
		boolean titleValid = title.contains("OrangeHRM");
		boolean output = urlValid && titleValid;
		assertTrue(output, "Leave module navigation failed And Defect is found");
	}

	@Test
	public void tc_06() {
		dash.getMyInfoMenu().click();
		String url = driver.getCurrentUrl();
		String breadcrumb = dash.getBreadcrumb().getText();
		boolean urlValid = url.contains("viewPersonalDetails");
		boolean breadcrumbValid = breadcrumb.contains("My Info");
		boolean output = urlValid && breadcrumbValid;
		assertTrue(output, "My Info module not opened correctly And Defect is found");
	}	

	@Test
	public void tc_07() {
		dash.getUserdropdown_icon().click();
		boolean logoutVisible = dash.getLogout().isDisplayed();
		String title = driver.getTitle();
		boolean pageStable = title.contains("OrangeHRM");
		boolean output = logoutVisible && pageStable;
		assertTrue(output, "User dropdown or logout option failed And Defect is found");
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
		String url = driver.getCurrentUrl();
		boolean titleValid = title.contains("OrangeHRM");
		boolean sessionValid = !url.contains("login");
		boolean output = titleValid && sessionValid;
		assertTrue(output, "Dashboard session or page title incorrect And Defect is found");
	}
}
