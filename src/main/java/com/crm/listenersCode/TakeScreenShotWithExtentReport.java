package com.crm.listenersCode;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClass.BaseClassDws;

public class TakeScreenShotWithExtentReport extends BaseClassDws implements ITestListener {
	
	public ExtentReports report;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test=report.createTest(name);
		test.log(Status.INFO,"Welcome to our class.....");
		test.log(Status.INFO,"My wonderfull fellows....");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Your testcase has passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Your testcase has failed");
		TakesScreenshot ts = (TakesScreenshot) driver;
		String from = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(from);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Your testcase has skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		File path = new File("./ExtentReport/Capture.html");
		spark = new ExtentSparkReporter(path);
		spark.config().setDocumentTitle("DemoWebShop");
		spark.config().setReportName("Shubham");
		spark.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.setSystemInfo("OS","Windows-11");
		report.setSystemInfo("Browser","Chrome");
		report.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	
}
