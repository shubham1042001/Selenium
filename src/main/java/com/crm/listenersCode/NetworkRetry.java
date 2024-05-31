package com.crm.listenersCode;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class NetworkRetry implements IRetryAnalyzer{

	int start=0; int end=2;
	@Override
	public boolean retry(ITestResult result) {
	
		while (start<end) {
			start++;
			return true;
		}
		return false;
	}

	
}
