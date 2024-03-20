/**
 * This class implements TestNG ITestListener interface to perform actions based on test events.
 * It extends the test_utilities class to utilize screenshot capture utilities.
 */
package base;

import java.io.IOException;


import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utilities.test_utilities;


public class Listeners extends test_utilities implements ITestListener{
	
    /**
     * Called when a test starts.
     * 
     * @param result The result of the test that just started.
     */

	public void onTestStart(ITestResult result) {
			Reporter.log("Test started: \n");
			try {
				 String path = getSnapshot(result.getMethod().getMethodName());
				 System.setProperty("org.uncommons.reportng.escape-output","false");
				 Reporter.log(" <a href='"+path+"'> <img src='"+path+"' height='200' width='200'/> </a>  ");

			} catch (IOException e) {
				e.printStackTrace();
			}
		  }

    /**
     * Called when a test fails.
     * 
     * @param result The result of the test that failed.
     */

	public void onTestFailure(ITestResult result) {
		Reporter.log("Test Failed: ");
		try {
			 String path = getSnapshot(result.getMethod().getMethodName());
			 System.setProperty("org.uncommons.reportng.escape-output","false");
			 Reporter.log(" <a href='"+path+"'> <img src='"+path+"' height='200' width='200'/> </a>  ");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
    /**
     * Called when a test succeeds.
     * 
     * @param result The result of the test that succeeded.
     */

	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test Successed");
	    System.out.println("Test Successed");
	    try {
			String path = getSnapshot(result.getMethod().getMethodName());
			System.setProperty("org.uncommons.reportng.escape-output","false");
			Reporter.log(" <a href='"+path+"'> <img src='"+path+"' height='200' width='200'/> </a>  ");
		} catch (IOException e) {
			e.printStackTrace();
		}  		
	}



}
