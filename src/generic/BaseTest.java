package generic;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class BaseTest implements IAutoConstanst{
	public  WebDriver driver;
	static{
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
	@BeforeMethod
	public void openApplication(){
		driver = new FirefoxDriver();
		String url = Lib.getPropertyValue("URL");
		driver.get(url);
		String implicitWait = Lib.getPropertyValue("ImplicitWait");
		int implicitWaitPeriod = Integer.parseInt(implicitWait);
		driver.manage().timeouts().implicitlyWait(implicitWaitPeriod, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeApplication(){
		driver.close();
	}
}
