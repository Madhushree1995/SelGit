package utils;

	import org.testng.annotations.Test;

	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;

	public class LearnReporter  {
	   @Test
	   public void repoter(){
	       ExtentReports extent = new ExtentReports("./reports/result.html",true);
	       ExtentTest test = extent.startTest("TC002_MergeLead", "Mergeing two leads in LeafTaps");
	       test.assignCategory("smoke");
	       test.assignAuthor("Madhu");
	       test.log(LogStatus.PASS, "User name entered succesfully"+test.addScreenCapture("./../snaps/img1.png"));
	       test.log(LogStatus.PASS, "Unable to enter username"+test.addScreenCapture("./../snaps/img2.png"));
	       test.log(LogStatus.PASS,"The browser is"+test.addScreenCapture("./../snaps/img3.png"));
	       extent.endTest(test);
	       extent.flush();
	   }

	}


