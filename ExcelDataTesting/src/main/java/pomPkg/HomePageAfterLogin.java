package pomPkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageAfterLogin {

	WebDriver driver;
	@FindBy (xpath="//div[@aria-label='More options']")
	private WebElement clicktoShowLogOut;
	
	@FindBy (xpath="//span[text()='Log Out']")
	private WebElement clickOnLogOut;
	
	public HomePageAfterLogin(WebDriver deriver)
	{
		PageFactory.initElements(deriver, this);
	}
	
	public void clickOntoshowArrow()
	{
		clicktoShowLogOut.click();
	}
	
	public void clickOnLogOut()
	{
		clickOnLogOut.click();
	}
}
