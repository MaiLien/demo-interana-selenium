package BlueOtter.Interana.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExploreFrame {

	private WebDriver driver;

	@FindBy(xpath = "//a[@href='#/explorer/']")
	private WebElement exploreBtn;

	
	private WebElement goBtn;

	@FindBy(xpath = ".//div[contains(@class,'explorerWidget')]//div[contains(@class,'controlHeading')]")
	private WebElement explorerFrame_downArrow;
	
	@FindBy(xpath="//div[contains(@class,'explorerWidget')]//div[contains(@class,'row-view')]//div[@class='input-search-container']")
	private WebElement explorerFrame_viewSelect;
	
	private String explorerFrame_viewOptionXpath = ".//div[contains(@class,'row-view')]//div[@class='search-result']//ol//li//span[@class='text' and text()='%s']";
	
	@FindBy(xpath = "//div[contains(@class,'timeWidget')]//input[@name='start']")
	private WebElement timeFrame_startTime;

	@FindBy(xpath = "//div[contains(@class,'timeWidget')]//div[contains(@class,'controlHeading')]")
	private WebElement timeFrame_downArrow;

	@FindBy(xpath = "//div[contains(@class,'metricsWidget')]//div[contains(@class,'chzn-container')]")
	private WebElement measureFrame_measureSelect;
	
	private String measureFrame_measureOptionXpath = ".//div[@class='chzn-drop']//ul//li[text()='%s']";
	
	@FindBy(xpath="//div[contains(@class,'metricsWidget')]//div[@class='input-search-container']")
	private WebElement measureFrame_firstBoxSelect;
	
	private String measureFrame_firstBoxOptionXpath= "//div[contains(@class,'metricsWidget')]//div[@class='search-result']//ol//li//span[text()='%s']";

	public ExploreFrame(WebDriver _driver) {
		this.driver = _driver;
//		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 60);
//		PageFactory.initElements(factory, this);
		PageFactory.initElements(driver, this);
	}

	public void open() {
		exploreBtn.click();
	}

	public void minimizeExplore() {
		explorerFrame_downArrow.click();
	}

	public void minimizeTime() {
		timeFrame_downArrow.click();
	}

	public void setStartTime(String _startTime) {
		timeFrame_startTime.sendKeys(_startTime);
	}
	
	public void cleanStartTime() {
		timeFrame_startTime.clear();
	}
	
	public void clickGoButton() {
		goBtn.click();
	}
	
	public void selectViewByVisibleText(String view) {
		explorerFrame_viewSelect.click();
		String optionXpath = String.format(explorerFrame_viewOptionXpath, view);
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}
	
	public void selectMeasureByVisibleText(String measure) {
		measureFrame_measureSelect.click();
		String optionXpath = String.format(measureFrame_measureOptionXpath, measure);
//		WebElement option = driver.findElement(By.xpath(optionXpath));
//		option.click();
		driver.findElement(By.xpath(optionXpath)).click();
	}
	
	public void selectFirstBoxByVisibleText(String measure) {
		measureFrame_firstBoxSelect.click();
		String optionXpath = String.format(measureFrame_firstBoxOptionXpath, measure);
		WebElement option = driver.findElement(By.xpath(optionXpath));
		option.click();
	}

}
