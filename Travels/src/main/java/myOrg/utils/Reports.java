package myOrg.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	static ExtentReports extentReport;
	public static ExtentReports getReportObject(String reportName, String documentTitle) {
		String path = System.getProperty("user.dir")+"/reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName(reportName);
		reporter.config().setDocumentTitle(documentTitle);
		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Tester", "Swami");
		return extentReport;
	}

}
