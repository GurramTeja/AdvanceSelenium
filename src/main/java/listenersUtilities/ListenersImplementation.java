package listenersUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseClass.BaseClass;

public class ListenersImplementation implements ITestListener,ISuiteListener{
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		Reporter.log("report configuration",true);
		Date d=new Date();
		String newdate = d.toString().replace(" ", "_").replace(":", "_");
		spark=new ExtentSparkReporter("./AdvanceReport/report_"+newdate+".html");
		spark.config().setDocumentTitle("NinzaCRM test result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows 10");
		report.setSystemInfo("Browser","Edge");

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		report.flush();
		Reporter.log("report backup",true);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO,"===="+result.getMethod().getMethodName()+"execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testname = result.getMethod().getMethodName();
		Reporter.log("===="+testname+"FAILURE====",true);
		Date d=new Date();
		 String newdate = d.toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		 String temp = ts.getScreenshotAs(OutputType.BASE64);
		 test.addScreenCaptureFromBase64String(temp, testname+newdate);
		 test.log(Status.FAIL,"===="+testname+"FAILURE====");
		 
		 /*
		 File perm = new File("./errorShot/"+testname+""+newdate+".png");
		 try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
	
}
