package FunctionalTesting;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.LeaveBase;

@Listeners(com.crm.Listeners.ExtentReportListeners.class)
public class LeaveTest extends LeaveBase {

	@BeforeMethod
	public void init() throws Exception {
		openLeaveModule();
	}

	@Test
	public void tc_01() {
		String header = leave.getLeaveHeader().getText();
		String url = driver.getCurrentUrl();
		boolean output = header.equalsIgnoreCase("Leave") && url.contains("leave");
		assertTrue(output, "Leave module not loaded correctly And Defect is found");
	}

	@Test
	public void tc_02() {
		boolean containerVisible = leave.getLeaveContainer().isDisplayed();
		String title = driver.getTitle();
		boolean output = containerVisible && title.contains("OrangeHRM");
		assertTrue(output, "Leave page UI not rendered properly And Defect is found");
	}

	@Test
	public void tc_03() {
		leave.getApplyLeave().click();
		String url = driver.getCurrentUrl();
		boolean breadcrumbUpdated = leave.getBreadcrumb().getText().contains("Apply");
		boolean output = url.contains("applyLeave") && breadcrumbUpdated;
		assertTrue(output, "Apply Leave navigation failed And Defect is found");
	}

	@Test
	public void tc_04() {
		leave.getLeaveList().click();
		String breadcrumb = leave.getBreadcrumb().getText();
		boolean searchEnabled = leave.getSearchButton().isEnabled();
		boolean output = breadcrumb.contains("Leave List") && searchEnabled;
		assertTrue(output, "Leave List page not functional And Defect is found");
	}

	@Test
	public void tc_05() {
		leave.getAssignLeave().click();
		String url = driver.getCurrentUrl();
		String header = leave.getLeaveHeader().getText();
		boolean output = url.contains("assignLeave") && header.equalsIgnoreCase("Leave");
		assertTrue(output, "Assign Leave page not opened correctly And Defect is found");
	}

	@Test
	public void tc_06() {
		leave.getLeaveList().click();
		leave.getSearchButton().click();
		String pageSource = driver.getPageSource();
		boolean output = pageSource.contains("Records") || pageSource.contains("No Records");
		assertTrue(output, "Leave search result not loaded And Defect is found");
	}

	@Test
	public void tc_07() {
		leave.getApplyLeave().click();
		String title = driver.getTitle();
		String url = driver.getCurrentUrl();
		boolean output = title.contains("OrangeHRM") && url.contains("applyLeave");
		assertTrue(output, "Apply Leave page validation failed And Defect is found");
	}

	@Test
	public void tc_08() {
		leave.getLeaveMenu().click();
		String breadcrumb = leave.getBreadcrumb().getText();
		boolean containerVisible = leave.getLeaveContainer().isDisplayed();
		boolean output = breadcrumb.contains("Leave") && containerVisible;
		assertTrue(output, "Leave module reload failed And Defect is found");
	}

	@Test
	public void tc_09() {
		leave.getAssignLeave().click();
		String pageSource = driver.getPageSource();
		boolean output = pageSource.contains("Employee") || pageSource.contains("Assign");
		assertTrue(output, "Assign Leave form not loaded And Defect is found");
	}

	@Test
	public void tc_10() {
		String title = driver.getTitle();
		String url = driver.getCurrentUrl();
		boolean output = title.contains("OrangeHRM") && url.contains("leave");
		assertTrue(output, "Leave module page integrity failed And Defect is found");
	}
}
