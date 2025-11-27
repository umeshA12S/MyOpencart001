package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;

 public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext textContext) {
	/*  SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	  Date dt = new Date();
      String currentdatetimestamp=df.format(dt);
    */
	 String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
      
	 repName ="Test-Report-" +timeStamp +".html";
	 sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName); //new report generate//specify the location of the report.
	 
	 sparkReporter.config().setDocumentTitle("Opencart automation report");//title of report
	 sparkReporter.config().setReportName("Opencart Functional Testing");// name of the report
	 sparkReporter.config().setTheme(Theme.DARK);
	
	 extent = new ExtentReports();
	 extent.attachReporter(sparkReporter);
	 extent.setSystemInfo("application","opencart");
	 extent.setSystemInfo("Module","admin");
	 extent.setSystemInfo("Sub Module", "Customers");
	 extent.setSystemInfo("username",System.getProperty("user.name"));
	 extent.setSystemInfo("Environment","QA");
	 
	 String os =textContext.getCurrentXmlTest().getParameter("os");
	 extent.setSystemInfo("operating system", os);
	
	 String browser = textContext.getCurrentXmlTest().getParameter("browser");
	 extent.setSystemInfo("Browser", browser);
	 
	List<String> includedGroups =textContext.getCurrentXmlTest().getIncludedGroups();
	if(!includedGroups.isEmpty()) {
	 extent.setSystemInfo("Groups", includedGroups.toString());
	}

}
	public void onTestSuccess(ITestResult result) {
		
	test= extent.createTest(result.getTestClass().getName());	
	test.assignCategory(result.getMethod().getGroups()); //to display groups in report	
	test.log(Status.PASS,result.getName()+"got successfully executed");
	}	
	
/*	public void onTestFailure(ITestResult result) {
	test= extent.createTest(result.getTestClass().getName());	
	test.assignCategory(result.getMethod().getGroups());
	
	test.log(Status.FAIL, result.getName()+"got failed");
	test.log(Status.INFO,result.getThrowable().getMessage());
	
	try {
		String imgPath = new BaseClass().captureScreen(result.getName());
	    test.addScreenCaptureFromPath(imgPath);
	}catch(Exception e1) {
		e1.printStackTrace();
	}
}
*/

	public void onTestFailure(ITestResult result) {
	    test = extent.createTest(result.getTestClass().getName());
	    test.assignCategory(result.getMethod().getGroups());

	    test.log(Status.FAIL, result.getName() + " got failed");
	    test.log(Status.INFO, result.getThrowable().getMessage());

	    try {
	        // Access the shared static driver safely
	        BaseClass base = new BaseClass();
	        String imgPath = base.captureScreen(result.getName());
	        if (imgPath != null) {
	            test.addScreenCaptureFromPath(imgPath);
	        } else {
	            test.log(Status.WARNING, "Screenshot not captured (driver was null or closed).");
	        }
	    } catch (Exception e1) {
	        e1.printStackTrace();
	        test.log(Status.WARNING, "Exception while capturing screenshot: " + e1.getMessage());
	    }
	}

	public void onTestSkipped(ITestResult result) {
		test= extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
	    test.log(Status.SKIP,result.getName()+"got skipped");
	    test.log(Status.INFO,result.getThrowable().getMessage());
	
	}
	public void onFinish(ITestContext testContext) {
		extent.flush();
		
		String pathOfExtentReport= System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	
}



