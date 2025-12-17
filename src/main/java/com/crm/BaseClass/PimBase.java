package com.crm.BaseClass;

import com.crm.POM.Dashboard;
import com.crm.POM.PIM;

public class PimBase extends LoginAction {

	protected PIM pim;
	protected Dashboard dash;

	public void openPimModule() throws Exception {

		login();

		dash = new Dashboard(driver);
		dash.getPimMenu().click();

		pim = new PIM(driver);
	}
}
