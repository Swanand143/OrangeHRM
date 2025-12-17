package FunctionalTesting;

import org.testng.Assert;
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
		Assert.assertTrue(leave.getLeaveMenu().isDisplayed());
	}

	@Test
	public void tc_02() {
		Assert.assertTrue(leave.getApplyLeave().isDisplayed());
	}

	@Test
	public void tc_03() {
		leave.getApplyLeave().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("applyLeave"));
	}

	@Test
	public void tc_04() {
		Assert.assertTrue(leave.getLeaveList().isDisplayed());
	}

	@Test
	public void tc_05() {
		leave.getLeaveList().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("viewLeaveList"));
	}

	@Test
	public void tc_06() {
		Assert.assertTrue(leave.getAssignLeave().isDisplayed());
	}

	@Test
	public void tc_07() {
		leave.getAssignLeave().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("assignLeave"));
	}

	@Test
	public void tc_08() {
		Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
	}

	@Test
	public void tc_09() {
		leave.getLeaveMenu().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("leave"));
	}

	@Test
	public void tc_10() {
		Assert.assertTrue(driver.getPageSource().contains("Leave"));
	}
}
