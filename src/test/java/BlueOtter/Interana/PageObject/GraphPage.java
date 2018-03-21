package BlueOtter.Interana.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GraphPage {
	
	private WebDriver driver;

	@FindBy(xpath = "//div[@class='chartCanvasTitleText']")
	private WebElement chartTitle;

	@FindBy(xpath = "//div[@class='chartCanvasTitleSummary']")
	private WebElement chartSummary;
	
	@FindBy(xpath="//div[@class='interanaChartCanvas chartCanvas_table']//div[@class='header-cell '][1]//div[@class='header-value-wrapper']")
	private WebElement datasetHeader;
	
	@FindBy(xpath="//div[@class='interanaChartCanvas chartCanvas_table']//div[@class='header-cell '][2]//div[@class='header-value-wrapper']")
	private WebElement measureHeader;
	
	public GraphPage(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(this.driver, this);
	}

	public String getChartTitle() {
		return chartTitle.getText();
	}

	public String getChartSummary() {
		return chartSummary.getText();
	}

	public String getDatasetHeader() {
		return datasetHeader.getText();
	}

	public String getMeasureHeader() {
		return measureHeader.getText();
	}

}
