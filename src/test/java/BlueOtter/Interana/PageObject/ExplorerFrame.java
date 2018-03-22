package BlueOtter.Interana.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExplorerFrame {

	private WebDriver driver;

	@FindBy(xpath = ".//div[contains(@class,'explorerWidget')]//div[contains(@class,'controlHeading')]")
	private WebElement downArrow;

	@FindBy(xpath = "//div[contains(@class,'explorerWidget')]//div[contains(@class,'row-view')]//div[@class='input-search-container']")
	private WebElement viewSelect;

	private String viewOptionXpath = ".//div[contains(@class,'row-view')]//div[@class='search-result']//ol//li//span[@class='text' and text()='%s']";

	public ExplorerFrame(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}

	public void minimize() {
		downArrow.click();
	}

	public void selectViewByVisibleText(String view) {
		viewSelect.click();
		String optionXpath = String.format(viewOptionXpath, view);
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

}
