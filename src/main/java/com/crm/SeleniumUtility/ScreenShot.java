package com.crm.SeleniumUtility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.BaseClass.BaseClass;

public class ScreenShot extends BaseClass {

	public static void screenShot() {

		try {
			if (driver == null) {
				return;
			}

			TakesScreenshot ts = (TakesScreenshot) driver;
			String base64 = ts.getScreenshotAs(OutputType.BASE64);
			ExtentReport.test.addScreenCaptureFromBase64String(base64);

		} catch (Exception e) {
			System.out.println("Screenshot capture failed: " + e.getMessage());
		}
	}
}
