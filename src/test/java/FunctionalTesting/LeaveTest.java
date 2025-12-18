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
		boolean output = driver.getCurrentUrl().contains("leave");
		assertTrue(output, "Leave module URL not loaded And Defect is found");
	}

	@Test
	public void tc_02() {
		leave.getApplyLeave().click();
		boolean output = driver.getCurrentUrl().contains("applyLeave");
		assertTrue(output, "Apply Leave navigation failed And Defect is found");
	}

	@Test
	public void tc_03() {
		leave.getLeaveList().click();
		boolean output = driver.getCurrentUrl().contains("viewLeaveList");
		assertTrue(output, "Leave List navigation failed And Defect is found");
	}

	@Test
	public void tc_04() {
		leave.getAssignLeave().click();
		boolean output = driver.getCurrentUrl().contains("assignLeave");
		assertTrue(output, "Assign Leave navigation failed And Defect is found");
	}

	@Test
	public void tc_05() {
		boolean output = driver.getTitle().equalsIgnoreCase("OrangeHRM");
		assertTrue(output, "Leave page title incorrect And Defect is found");
	}

	@Test
	public void tc_06() {
		boolean output = driver.getPageSource().contains("Apply");
		assertTrue(output, "Apply Leave text missing And Defect is found");
	}

	@Test
	public void tc_07() {
		boolean output = driver.getPageSource().contains("Leave List");
		assertTrue(output, "Leave List text missing And Defect is found");
	}

	@Test
	public void tc_08() {
		boolean output = driver.getPageSource().contains("Assign Leave");
		assertTrue(output, "Assign Leave text missing And Defect is found");
	}

	@Test
	public void tc_09() {
		driver.navigate().refresh();
		boolean output = driver.getCurrentUrl().contains("leave");
		assertTrue(output, "Leave page refresh failed And Defect is found");
	}

	@Test
	public void tc_10() {
		boolean output = !driver.getCurrentUrl().contains("login");
		assertTrue(output, "Unexpected logout from Leave module And Defect is found");
	}
}
