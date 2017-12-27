package utils;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LearnReport {
	@Test
	public void reporter() {
		ExtentReports extent = new ExtentReports("./reports/result.html", false);
		ExtentTest test = extent.startTest("Tc001_CreateLead", "create new lead in leaftaps");
		test.assignCategory("smoke");
		
		test.log(LogStatus.PASS, "usernam entered succesfully"+test.addScreenCapture("./../snaps/img1.png"));
		test.log(LogStatus.PASS, "usernam entered succesfully"+test.addScreenCapture("./../snaps/img2.png"));
		test.log(LogStatus.WARNING, "usernam entered succesfully"+test.addScreenCapture("./../snaps/img2.png"));
		extent.endTest(test);
		extent.flush();
	}

}

