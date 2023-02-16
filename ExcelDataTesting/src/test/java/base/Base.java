package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {

	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation_fileFolder\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		return driver;
	}
	public static WebDriver openFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver","D:\\Automation_fileFolder\\geckodriver-v0.32.0-win64\\geckodriver.exe" );
		WebDriver driver= new FirefoxDriver();	
	
		return driver;
	}
	public static WebDriver openOperaBrowser()
	{
		System.setProperty("webdriver.opera.driver","D:\\Automation_fileFolder\\operadriver_win64\\operadriver_win64\\operadriver.exe");
		WebDriver driver= new OperaDriver();
		return driver;
	}
}
