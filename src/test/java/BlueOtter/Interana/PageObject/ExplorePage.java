package BlueOtter.Interana.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExplorePage {

	private WebDriver driver;

	private ExplorerFrame explorerFrame;
	private TimeFrame timeFrame;
	private MeasureFrame measureFrame;

	@FindBy(xpath = "//a[@href='#/explorer/']")
	private WebElement exploreBtn;

	@FindBy(xpath = "//div[contains(@class,'goBtn')]")
	private WebElement goBtn;

	public ExplorePage(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);

		explorerFrame = new ExplorerFrame(driver);
		timeFrame = new TimeFrame(driver);
		measureFrame = new MeasureFrame(driver);

	}

	public void open() {
		exploreBtn.click();
	}

	public void clickGoButton() {
		goBtn.click();
	}

	public void selectViewAtExploreFrame(String view) {
		explorerFrame.selectViewByVisibleText(view);
	}

	public void minimizeExploreFrame() {

		explorerFrame.minimize();
	}

	public void setStartTimeAtTimeFrame(String startTime) {
		timeFrame.setStartTime(startTime);
	}

	public void minimizeTimeFrame() {
		timeFrame.minimize();
	}

	public void selectMeasureAtMeasureFrame(String measureValue) {
		measureFrame.selectMeasureByVisibleText(measureValue);

	}

	public void selectFirstBoxAtMeasureFrame(String measureAtFirstBox) {
		measureFrame.selectFirstBoxByVisibleText(measureAtFirstBox);
	}

}
