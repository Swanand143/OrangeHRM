package com.crm.BaseClass;

import com.crm.POM.Dashboard;
import com.crm.POM.Leave;

public class LeaveBase extends LoginAction {

	protected Leave leave;
	protected Dashboard dash;

	public void openLeaveModule() throws Exception {

		login();

		dash = new Dashboard(driver);
		dash.getLeaveMenu().click();

		leave = new Leave(driver);
	}
}
