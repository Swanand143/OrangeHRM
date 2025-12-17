package com.crm.SeleniumUtility;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static ExtentReports report;
	public static ExtentTest test;

	public static void initReport(String moduleName) {

		File folder = new File("./src/test/resources/Report");
		if (!folder.exists()) {
			folder.mkdirs();
		}

		String path = "./src/test/resources/Report/" + moduleName + "Report.html";

		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setDocumentTitle("OrangeHRM Automation");
		spark.config().setReportName(moduleName + " Module");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);

		report.setSystemInfo("Project", "OrangeHRM");
		report.setSystemInfo("Module", moduleName);
		report.setSystemInfo("Browser", "Chrome");
	}
}
