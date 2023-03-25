package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;// UI of the project
	public ExtentReports extent;// populate common info on the report
	public ExtentTest test;// creating test case entries in the report and update status of the test method
     String repName;
	public void onStart(ITestContext context) {
        String timeStamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.SS").format(new Date());
        repName="Test-Report-"+timeStamp+".html";
		sparkReporter = new ExtentSparkReporter( ".\\reports\\"+repName);

		sparkReporter.config().setDocumentTitle("Opencart Automation Report");
		// Name of the report
		sparkReporter.config().setReportName("Opencart Functional Testing ");
		// Dark Theme
		sparkReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Application name", "Open_cart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customer");
		extent.setSystemInfo("User Name", "Pooja_Mallesh");
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Browser name", "Chrome,firefox,edge");

	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());// create a new entry in the report
		test.log(Status.PASS, "Test Passed");// update the result as pass
	}

	public void onTestFailure(ITestResult result){
		test = extent.createTest(result.getName());// create a new entry in the report
		test.log(Status.FAIL, "Test case Failed is :" + result.getName());
		test.log(Status.FAIL, "Test case Failed cause is :" + result.getThrowable().getMessage());
		try {
			String imgPath =new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());	// create a new entry in the report
		test.createNode(result.getName());
	    test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test case Skipped is :" + result.getName());
		test.log(Status.SKIP,  result.getThrowable().getMessage());
		
	}

	public void onFinish(ITestContext context) {

		extent.flush();
	}

}