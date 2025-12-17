package FunctionalTesting;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.MyInfoBase;

@Listeners(com.crm.Listeners.ExtentReportListeners.class)
public class MyInfoTest extends MyInfoBase {

	@BeforeMethod
	public void init() throws Exception {
		openMyInfoModule();
	}

	@Test
	public void tc_01() {
		Assert.assertTrue(myInfo.getMyInfoMenu().isDisplayed());
	}

	@Test
	public void tc_02() {
		Assert.assertTrue(myInfo.getSaveButton().isDisplayed());
	}

	@Test
	public void tc_03() {
		Assert.assertTrue(myInfo.getSaveButton().isEnabled());
	}

	@Test
	public void tc_04() {
		myInfo.getMyInfoMenu().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"));
	}

	@Test
	public void tc_05() {
		Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
	}

	@Test
	public void tc_06() {
		Assert.assertTrue(driver.getPageSource().contains("Personal Details"));
	}

	@Test
	public void tc_07() {
		Assert.assertTrue(driver.getPageSource().contains("Employee"));
	}

	@Test
	public void tc_08() {
		myInfo.getSaveButton().click();
		Assert.assertTrue(driver.getPageSource().contains("Successfully"));
	}

	@Test
	public void tc_09() {
		Assert.assertTrue(myInfo.getMyInfoMenu().isEnabled());
	}

	@Test
	public void tc_10() {
		Assert.assertTrue(driver.getCurrentUrl().contains("myInfo"));
	}
}
