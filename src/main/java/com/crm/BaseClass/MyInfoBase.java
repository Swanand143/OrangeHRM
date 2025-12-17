package com.crm.BaseClass;

import com.crm.POM.Dashboard;
import com.crm.POM.MyInfo;

public class MyInfoBase extends LoginAction {

	protected MyInfo myInfo;
	protected Dashboard dash;

	public void openMyInfoModule() throws Exception {

		login();

		dash = new Dashboard(driver);
		dash.getMyInfoMenu().click();

		myInfo = new MyInfo(driver);
	}
}
