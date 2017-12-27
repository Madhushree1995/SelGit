package wrappers;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import excel.ReadExcel;

public class ProjectSpecificWrapper extends GenericWrapper {
	@Parameters({"browser","url","username","password"})
	@BeforeMethod
	public void login() throws Exception{
		invokeApp("Chrome", "http://leaftaps.com/opentaps/control/main");
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByLink("CRM/SFA");
		}
	
	@AfterMethod
	public void closeApp() {
		quitBrowser();
	}
	
	@DataProvider(name="fetchData")
	public Object[][] getdata() throws InvalidFormatException, IOException
	{
		ReadExcel excel = new ReadExcel();
		 return excel.readExcel();
	}

}
