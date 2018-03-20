package BlueOtter.Interana.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(name="l_username")
	private WebElement email;
	
	@FindBy(name="l_password")
	private WebElement password;
	
	@FindBy(id="signInBtn")
	private WebElement signInBtn;
	
	public LoginPage(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void setEmail(String _email) {
		this.email.sendKeys(_email);
	}
	
	public void setPassword(String _password) {
		this.password.sendKeys(_password);
	}
	
	public void clickSignInBtn() {
		this.signInBtn.click();
	}
	
	public void login(String _email, String _password) {
		setEmail(_email);
		setPassword(_password);
		clickSignInBtn();
	}

}
