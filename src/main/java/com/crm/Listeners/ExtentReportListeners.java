package com.crm.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.crm.SeleniumUtility.ExtentReport;
import com.crm.SeleniumUtility.ScreenShot;

public class ExtentReportListeners implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		String className = context.getAllTestMethods()[0]
				.getTestClass()
				.getRealClass()
				.getSimpleName();

		ExtentReport.initReport(className);
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.test =
				ExtentReport.report.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReport.test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentReport.test.log(Status.FAIL, "Test Failed");
		ScreenShot.screenShot();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentReport.test.log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReport.report.flush();
	}
}
