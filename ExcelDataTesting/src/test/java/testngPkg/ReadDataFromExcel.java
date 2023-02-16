package testngPkg;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import pomClasses.LoginOrSignUpPage;
import pomPkg.LoginPageClass;
import utils.Uility;

public class ReadDataFromExcel extends Uility{

	private String testId;
	WebDriver driver;
	@BeforeClass
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation_fileFolder\\chromedriver_win32 (2)\\chromedriver.exe");
		driver= new ChromeDriver();
		
	}
	
	@BeforeMethod
	public void beforeMethd()
	{
		//private String testId;
		System.out.println("Before Method");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		LoginPageClass LoginPageClass=new LoginPageClass(driver);
	}
	@Test//(dataProvider="LoginData")
	public void testMethod() throws IOException
	{
		testId="Ts-001";
		LoginPageClass loginPageClass=new LoginPageClass(driver);
		
		loginPageClass.sendUserName(Uility.getExcelCellDataValue("Sheet1", 1, 0));
		loginPageClass.sendPassword(Uility.getExcelCellDataValue("Sheet1", 1, 1));
		String exp=Uility.getExcelCellDataValue("Sheet1", 1, 2);
		System.out.println("Expected result is "+exp);
		loginPageClass.clickOnLoginButton();
		String actTitle=driver.getTitle();
		String actUrl=driver.getCurrentUrl();
		System.out.println("Actual url is "+actUrl);
		String expUrl="https://www.facebook.com/checkpoint/disabled/?next";
		System.out.println("Actual String "+actTitle);
		String expTitle="Facebook";
		SoftAssert softAssert=new SoftAssert();
		if(exp.equals("Valid"))
		{    if(actUrl.equals(expUrl))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
				System.out.println("not same");
			}
		}
		else if(exp.equals("Invalid"))
		{
			if(actTitle.equals(expTitle))
			{
				softAssert.assertTrue(false);
			}
			else
			{
				softAssert.assertTrue(true);
			}
		}		}
	
	/*@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		int totalRow=	Uility.getRowCount("Sheet1");
		System.out.println("total rows present in sheet is "+totalRow);

		int totalCol= Uility.getCellCount("Sheet1", totalRow);
		System.out.println("total cell present in sheet is "+totalCol);
		
		String logindata[][]=new String[totalRow][totalCol];
		for(int i=1;i<=totalRow;i++)
		{
			for(int j=0;j<totalCol;j++)
			{
				logindata[i-1][j]=Uility.getExcelCellDataValue("Sheet1", i, j);
			}
		}
		return logindata;
		
	}*/
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Uility.captureScreenShot(driver,testId );
		}
		driver.close();
	}
	
	@AfterClass
	public void afterClass()
	{
		//driver.close();
	}
	
}
