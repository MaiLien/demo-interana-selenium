package BlueOtter.Interana.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MeasureFrame {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//div[contains(@class,'metricsWidget')]//div[contains(@class,'chzn-container')]")
	private WebElement measureSelect;

	private String measureOptionXpath = ".//div[@class='chzn-drop']//ul//li[text()='%s']";

	@FindBy(xpath = "//div[contains(@class,'metricsWidget')]//div[@class='input-search-container']")
	private WebElement firstBoxSelect;

	private String firstBoxOptionXpath = "//div[contains(@class,'metricsWidget')]//div[@class='search-result']//ol//li//span[text()='%s']";

	public MeasureFrame(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectMeasureByVisibleText(String measure) {
		measureSelect.click();
		String optionXpath = String.format(measureOptionXpath, measure);
		WebElement option = driver.findElement(By.xpath(optionXpath));
		scrollDropdownToViewElement(option);
		option.click();
	}

	public void selectFirstBoxByVisibleText(String measure) {
		firstBoxSelect.click();
		String optionXpath = String.format(firstBoxOptionXpath, measure);
		WebElement option = driver.findElement(By.xpath(optionXpath));
		scrollDropdownToViewElement(option);
		option.click();
	}
	

	public void scrollDropdownToViewElement(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
}