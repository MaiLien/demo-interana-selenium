package BlueOtter.Interana.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimeFrame {

	private WebDriver driver;

	@FindBy(xpath = "//div[contains(@class,'timeWidget')]//input[@name='start']")
	private WebElement startTime;

	@FindBy(xpath = "//div[contains(@class,'timeWidget')]//div[contains(@class,'controlHeading')]")
	private WebElement downArrow;

	public TimeFrame(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}

	public void minimize() {
		downArrow.click();
	}

	public void setStartTime(String _startTime) {
		cleanStartTime();
		startTime.sendKeys(_startTime);
	}

	public void cleanStartTime() {
		startTime.clear();
	}

}