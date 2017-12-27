package testcases;

import org.junit.Test;

import wrappers.GenericWrapper;

public class TC_LoginAndLogout extends GenericWrapper {
	@Test
	public void login() {
		invokeApp("chrome", "http://leaftaps.com/opentaps/control/main");
		enterById("username","DemoSalesManager");
		enterById("password", "cmrsfa");
		clickByClassName("decorativeSubmit");
		clickByClassName("decorativeSubmit");
		
	}

}
