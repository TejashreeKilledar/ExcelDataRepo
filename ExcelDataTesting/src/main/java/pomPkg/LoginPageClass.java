package pomPkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass {

	WebDriver driver;
	@FindBy (xpath="//div[@aria-label='More options']")
	private WebElement clicktoShowLogOut;
	
	@FindBy (xpath="//span[text()='Log Out']")
	private WebElement clickOnLogOut;
	
	@FindBy (xpath="//input[@type='text']")
	private WebElement userName;
	
	@FindBy (xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath="//button[@name='login']")
	private WebElement login;
	
	public LoginPageClass(WebDriver deriver)
	{
		PageFactory.initElements(deriver, this);
	}
	
	public void sendUserName(String email)
	{
		userName.sendKeys(email);
		//return userName;
	}
	public void sendPassword(String pwd)
	{
		password.sendKeys(pwd);
		//return userName;
	}
	
	public void clickOnLoginButton()
	{
		login.click();
	}
	
	
}
