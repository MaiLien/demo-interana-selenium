package BlueOtter.Interana.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.graph.Graph;

import BlueOtter.Interana.PageObject.ExploreFrame;
import BlueOtter.Interana.PageObject.GraphPage;
import BlueOtter.Interana.PageObject.LoginPage;

public class VerifyGraphGeneration {

	WebDriver driver;

	String url = "https://demo.interana.com/";
	String email = "mailien.bk@gmail.com";
	String password = "Demo2018";

	String view = "Table";
	String measureAtSelect = "First";
	String measureAtFirstBox = "user";
	String startTime = "5 days ago";
	
	String chartTitle = "WIKIPEDIA - FIRST (USER)";
	String chartSummary = "Measuring first of user from 5 days ago to now (PDT)";
	String datasetHeader = "wikipedia";
	String measureHeader = "First user";

	@BeforeTest
	public void before() {
		System.setProperty("webdriver.gecko.driver", ".\\gecko\\v0.19.0\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(url);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(email, password);
	}

	@Test
	public void test() {
		ExploreFrame exploreFrame = new ExploreFrame(driver);

		// Click Explore button in the left side
		exploreFrame.open();

		// Select Table view in Explore frame
		exploreFrame.selectViewByVisibleText(view);

		// Click "Down arrow" in the upper right of the Explore frame to minimize it
		exploreFrame.minimizeExplore();

		// Input "5 days ago" to the Start text box in the Time frame
		exploreFrame.cleanStartTime();
		exploreFrame.setStartTime(startTime);

		// Click "Down arrow" in the upper right of the Time frame to minimize it
		exploreFrame.minimizeTime();

		// Select "First" in the Measure frame
		exploreFrame.selectMeasureByVisibleText(measureAtSelect);
		
		// Select "user" for measure column in the new box appears
		exploreFrame.selectFirstBoxByVisibleText(measureAtFirstBox);

		// Click "GO" button
		exploreFrame.clickGoButton();

		// Verify that graph is generated
		GraphPage graphPage = new GraphPage(driver);
		Assert.assertEquals(chartTitle, graphPage.getChartTitle().toUpperCase());
		Assert.assertEquals(chartSummary, graphPage.getChartSummary());
		Assert.assertEquals(datasetHeader, graphPage.getDatasetHeader());
		Assert.assertEquals(measureHeader, graphPage.getMeasureHeader());
		
	}

	@AfterTest
	public void after() {
		 driver.quit();
	}

}
