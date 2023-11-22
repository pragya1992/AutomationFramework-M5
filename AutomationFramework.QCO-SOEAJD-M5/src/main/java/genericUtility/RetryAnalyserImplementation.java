package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer {
	int count=0;
	int retryCount=3;//manual analysis(for server,network,sysncronization issues)
	
	public boolean retry(ITestResult result) {
		while(count<retryCount) {
			count++;
			return true;//retry 3 times
		}
		return false;//stop retrying
	}

}
