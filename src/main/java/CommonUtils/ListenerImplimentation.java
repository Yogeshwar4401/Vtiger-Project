package CommonUtils;

import java.io.IOException;

import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImplimentation implements ITestListener {


		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			String methodname = result.getMethod().getMethodName();
			Reporter.log("testscript execution started",true);
		}
		

		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			String methodname = result.getMethod().getMethodName();
			Reporter.log("testscript is passed",true);

		}
		

		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub
			String methodname = result.getMethod().getMethodName();
			Throwable message = result.getThrowable();
			Reporter.log("testscript is failed"+message,true);
		    WebDriverUtils wUtils = new WebDriverUtils();
		    try {
	        wUtils.screenShot(BaseClassMain.sdriver);
		    }catch (IOException e) {
		    	e.printStackTrace();
		    }
		}
		

		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			String methodname = result.getMethod().getMethodName();
			Reporter.log("testscript is skipped,",true);

		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
		}

		public void onTestFailedWithTimeout(ITestResult result) {
			// TODO Auto-generated method stub
		}

		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
		}

		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
		}
	}


