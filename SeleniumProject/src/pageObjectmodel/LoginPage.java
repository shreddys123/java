package pageObjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	@FindBy(linkText="Sign in")public WebElement login;
	@FindBy(id="email")public WebElement customerEmail;
	@FindBy(id="passwd")public WebElement customerPassword;
	@FindBy(xpath="//p[@class='submit']//span[1]")public WebElement signIn;
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]")public WebElement getLognErrText;
	
	public void customerLogin()
	{
		login.click();
		customerEmail.sendKeys("qatest423@gmail.com");
		customerPassword.sendKeys("Password");
		signIn.click();
	}
}	