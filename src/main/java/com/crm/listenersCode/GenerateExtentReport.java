package com.crm.listenersCode;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateExtentReport implements ITestListener {
	
	public ExtentReports report;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test=report.createTest(name);
		System.out.println("OnTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("OnTestSuccess");
		String name = result.getMethod().getMethodName();
		System.out.println("OnTestFailure");
		test.log(Status.PASS, name+" is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		System.out.println("OnTestFailure");
		test.log(Status.FAIL, name+" is failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
		System.out.println("OnTestSkipped");
		test.log(Status.SKIP, name+" is skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		File path = new File("./ExtentReport/TestRun.html");
		spark = new ExtentSparkReporter(path);
		spark.config().setDocumentTitle("DemoWebShop");
		spark.config().setReportName("Shubham");
		spark.config().setTheme(Theme.STANDARD);
		report = new ExtentReports();
		report.setSystemInfo("OS","Windows-11");
		report.setSystemInfo("Browser","Chrome");
		report.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("OnFinish");
		report.flush();
	}

	
}
