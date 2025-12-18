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
	
	// Verifies that the Dashboard page is loaded correctly by validating header text, URL, and page title.	
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

	// Ensures the main dashboard UI is visible and the breadcrumb correctly shows “Dashboard”.
	@Test
	public void tc_02() {
		boolean containerVisible = dash.getDashboardContainer().isDisplayed();
		String breadcrumb = dash.getBreadcrumb().getText();
		String title = driver.getTitle();
		boolean breadcrumbValid = breadcrumb.contains("Dashboard");
		boolean output = containerVisible && breadcrumbValid && title.contains("OrangeHRM");
		assertTrue(output, "Dashboard UI or breadcrumb incorrect And Defect is found");
	}
	
	// Navigates from Dashboard to Admin module and validates successful navigation using URL and title.
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
	
	// Clicks on PIM menu and verifies correct breadcrumb update and PIM page URL.
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
	
	// Navigates to the Leave module from Dashboard and confirms the page is loaded properly.			
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
	
	// Opens the My Info module and validates correct page URL and breadcrumb text.
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
	
	// Opens the user dropdown and verifies that the Logout option is visible without page instability.
	@Test
	public void tc_07() {
		dash.getUserdropdown_icon().click();
		boolean logoutVisible = dash.getLogout().isDisplayed();
		String title = driver.getTitle();
		boolean pageStable = title.contains("OrangeHRM");
		boolean output = logoutVisible && pageStable;
		assertTrue(output, "User dropdown or logout option failed And Defect is found");
	}
	
	// Performs logout action from Dashboard and validates redirection to the Login page.
	@Test
	public void tc_08() {
		dash.getUserdropdown_icon().click();
		dash.getLogout().click();
		String url = driver.getCurrentUrl();
		boolean output = url.contains("login");
		assertTrue(output, "Logout functionality failed And Defect is found");
	}
	
	// Verifies multi-module navigation from Admin to PIM works correctly from the Dashboard menu.
	@Test
	public void tc_09() {
		dash.getAdminMenu().click();
		dash.getPimMenu().click();
		String url = driver.getCurrentUrl();
		boolean output = url.contains("pim");
		assertTrue(output, "Dashboard menu navigation failed And Defect is found");
	}
	
	// Confirms that the Dashboard session remains active and the page title is correct.
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
