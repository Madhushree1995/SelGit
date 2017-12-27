package testcases;


import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import wrappers.GenericWrapper;

public class MergeLead extends GenericWrapper{
	@Test
		public void mergelead() {
		
			invokeApp("chrome", "http://leaftaps.com/opentaps/control/main");
			enterById("username","DemoSalesManager");
			enterById("password", "crmsfa");
			clickByClassName("decorativeSubmit");
			clickByLink("CRM/SFA");
			clickByLink("Leads");
			clickByLink("Merge Leads");
			clickByXpath("//img[@src='/images/fieldlookup.gif']");
			switchToWindow(1);
			enterByName("id","10171");
			clickByXpath("//button[@type='button']");
			clickByLinkWithNoSnap("10171");
			switchToWindow(0);
			clickByXpath("(//img[@src='/images/fieldlookup.gif'])[2]");
			switchToWindow(1);
			enterByName("id", "10178");
			clickByXpath("//button[@type='button']");
			clickByLinkWithNoSnap("10178");
			switchToWindow(0);
			clickByLinkWithNoSnap("Merge");
			acceptAlert();
			clickByLink("Find Leads");
			enterByName("id", "10171");
			
			
			
			
			
			
	}
	
}
