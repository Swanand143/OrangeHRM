package com.crm.BaseClass;

import com.crm.POM.Dashboard;

public class DashboardBase extends LoginAction {

	protected Dashboard dash;

	public void openDashboard() throws Exception {
		login();
		dash = new Dashboard(driver);
	}
}
