package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrapper implements Wrappers {

	public RemoteWebDriver driver;

	int i = 1;

	public void invokeApp(String browser, String url) {

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.navigate().to("http://leaftaps.com/opentaps/control/main");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("the browser " + browser + "launched sucessfully");
		} catch (WebDriverException e) {
			System.out.println("the browser " + browser + "could not be launched ");

		} finally {
			takeSnap();
		}
	}

	public void enterById(String idValue, String data) {

		try {
			driver.findElementById(idValue).clear();
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("the Data " + data + " Entered succesfully in the field" + idValue);
		} catch (NoSuchElementException e) {
			System.out.println("the Data " + data + " could not be  Entered succesfully in the field" + idValue);

		} catch (WebDriverException e) {
			System.out.println("unexpected error occured");
		} finally {
			takeSnap();
		}

	}

	public void enterByName(String nameValue, String data) {
		try {
			driver.findElementByName(nameValue).clear();
			driver.findElementByName(nameValue).sendKeys(data);
			System.out.println("the Data " + data + " Entered succesfully in the field" + nameValue);
		} catch (NoSuchElementException e) {
			System.out.println("the Data " + data + " could not be  Entered succesfully in the field" + nameValue);

		} catch (WebDriverException e) {
			System.out.println("unexpected error occured");
		} finally {
			takeSnap();
		}

	}

	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElementByXPath(xpathValue).clear();
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println("the Data " + data + " Entered succesfully in the field" + xpathValue);
		} catch (NoSuchElementException e) {
			System.out.println("the Data " + data + " could not be  Entered succesfully in the field" + xpathValue);

		} catch (WebDriverException e) {
			System.out.println("unexpected error occured");
		} finally {
			takeSnap();
		}

	}

	public boolean verifyTitle(String title) {
		boolean bReturn = false;
		try {
			if (driver.getTitle().equals(title)) {
				System.out.println("title matched with" + title);
			} else {
				System.out.println("title is not matched with the expected" + title);
			}
			bReturn = true;
		} catch (WebDriverException e) {
			System.out.println("unexpected error occured");
		} finally {
			takeSnap();
		}
		return bReturn;
	}

	public void verifyTextById(String id, String text) {
		String txt = driver.findElementById(id).getText();
		try {
			if (txt.equals(text)) {
				System.out.println("we got the " + text);
			} else {
				System.out.println("we did'nt get the " + text);
			}
		} catch (NoSuchElementException e) {
			System.out.println("unexpected error occured");

		} finally {
			takeSnap();
		}

	}

	public void verifyTextByXpath(String xpath, String text) {
		String xp = driver.findElementByXPath(xpath).getText();
		try {
			if (xp.equals(text)) {
				System.out.println("we recieved" + text);
			} else {
				System.out.println("we do not recieved" + text);
			}
		} catch (NoSuchElementException e) {
			System.out.println("unexpected error occured");
		} finally {
			takeSnap();
		}
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		String xp = driver.findElementByXPath(xpath).getText();
		try {
			if (xp.contains(text)) {
				System.out.println("we recieved" + text);
			} else {
				System.out.println("we do not recieved" + text);
			}
		} catch (NoSuchElementException e) {
			System.out.println("unexpected error occured");
		} finally {
			takeSnap();

		}

	}

	public void verifyTextContainsById(String id, String text) {
		String txt = driver.findElementById(id).getText();
		try {
			if (txt.contains(text)) {
				System.out.println("we got the " + text);
			} else {
				System.out.println("we did'nt get the " + text);
			}
		} catch (NoSuchElementException e) {
			System.out.println("unexpected error occured");

		} finally {
			takeSnap();
		}

	}

	public void clickById(String id) {
		try {
			driver.findElementById(id).click();
			System.out.println("the element id click succesfully");
		} catch (NoSuchElementException e) {
			System.out.println("the element " + id + "could not clickable");

		} finally {
			takeSnap();
		}

	}

	public void clickByClassName(String classVal) {
		try {
			driver.findElementByClassName(classVal).click();
			System.out.println("the element id click succesfully");
		} catch (NoSuchElementException e) {
			System.out.println("the element " + classVal + "could not clickable");

		} finally {
			takeSnap();
		}

	}

	public void clickByName(String name) {

		try {
			driver.findElementByName(name).click();
			System.out.println("the element id click succesfully");
		} catch (NoSuchElementException e) {
			System.out.println("the element " + name + "could not clickable");

		} finally {
			takeSnap();
		}
	}

	public void clickByLinkWithNoSnap(String name) {
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("the element id click succesfully");
		} catch (NoSuchElementException e) {
			System.out.println("the element " + name + "could not clickable");

		}
	}

	public void clickByLink(String name) {
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("the element id click succesfully");
		} catch (NoSuchElementException e) {
			System.out.println("the element " + name + "could not clickable");

		} finally {
			takeSnap();
		}

	}

	
	

	public void clickByXpath(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("the element id click succesfully");
		} catch (NoSuchElementException e) {
			System.out.println("the element " + xpathVal + "could not clickable");

		} finally {
			takeSnap();
		}

	}

	public String getTextById(String idVal) {
		String txt = null;
		try {
			txt = driver.findElementById(idVal).getText();
		} catch (NoSuchElementException e) {
			System.out.println("unexpected error occured");
		}
		return txt;
	}

	public String getTextByXpath(String xpathVal) {
		String txt = null;
		try {
			txt = driver.findElementByXPath(xpathVal).getText();
		} catch (NoSuchElementException e) {
			System.out.println("unexpected error occured");
		}
		return txt;
	}

	public void selectVisibileTextById(String id, String value) {
		try {
			WebElement dd = driver.findElementById(id);

			Select drop = new Select(dd);
			drop.selectByVisibleText(value);
			System.out.println("Slect " + value + "Successfully");
		} catch (NoSuchElementException e) {

			System.out.println("not selected" + value);
		}

	}

	public void selectIndexById(String id, int value) {
		try {
			WebElement dd = driver.findElementById(id);

			Select drop = new Select(dd);
			drop.selectByIndex(value);
			;
			System.out.println("Slect " + value + "Successfully");
		} catch (NoSuchElementException e) {
			System.out.println("not selected" + value);
		}

	}

	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			System.out.println("number of windows " + allWindowHandles.size());
			List<String> allHandles = new ArrayList<String>();
			allHandles.addAll(allWindowHandles);
			driver.switchTo().window(allHandles.get(index));
		} catch (NoSuchWindowException e) {
			System.out.println("The driver could not move to the given window by index " + i);
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}

	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();

	}

	public void quitBrowser() {
		try {
			driver.quit();
			System.out.println("The opened browsers are closed");
		} catch (WebDriverException e) {
			System.out.println("close the broswer");
		}

	}

	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/img" + i + ".png");
		try {
			FileUtils.copyFile(src, target);
		} catch (IOException e) {
			System.out.println("take the snap");
		}
		i++;

	}

	public void switchToFrame(String idorName) {
		try {

			driver.switchTo().frame(idorName);
			System.out.println("switch In to the Frame ");
		} catch (NoSuchFrameException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}

	}

}