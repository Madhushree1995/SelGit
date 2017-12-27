package basic;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeApp {
	
	@Test
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

}
