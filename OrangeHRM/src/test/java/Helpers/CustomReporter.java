package Helpers;

import org.testng.Reporter;

public class CustomReporter {
	
	public static void reportPassed(String message) {
		Reporter.log(message, false);
	}
	
	public static void reportFailed(String message) {
		Reporter.log(message, false);
	}

}
