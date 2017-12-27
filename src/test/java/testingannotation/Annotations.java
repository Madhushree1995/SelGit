package testingannotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("this executed before test");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("this is executed before class");

	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("this is executed before Method");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("this is executed before @test");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("this executed after AfterMethod");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("this is executed after BeforeMethod");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("this is executed after class");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("this is executed after test");
	}

	@Test
	public void test() {
		System.out.println("this is executed after all method");
	}
}
