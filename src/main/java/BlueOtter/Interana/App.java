package BlueOtter.Interana;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException {

		String url = "https://demo.interana.com/";
		String email = "mailien.bk@gmail.com";
		String password = "Demo2018";

		System.setProperty("webdriver.gecko.driver", ".\\gecko\\v0.19.0\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get(url);
		driver.findElement(By.name("l_username")).sendKeys(email);
		driver.findElement(By.name("l_password")).sendKeys(password);
		driver.findElement(By.id("signInBtn")).click();

		driver.findElement(By.xpath("//a[@href='#/explorer/']")).click();

		//Dong 2 phan tren
		driver.findElement(By.xpath(".//div[contains(@class,'explorerWidget')]//div[contains(@class,'controlHeading')]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'timeWidget')]//div[contains(@class,'controlHeading')]")).click();
		
		//Chon First
		driver.findElement(By.xpath("//div[contains(@class,'metricsWidget')]//div[contains(@class,'chzn-container')]")).click();
		driver.findElement(By.xpath(".//div[@class='chzn-drop']//ul//li[text()='First']")).click();

		//Chon user
		driver.findElement(By.xpath("//div[contains(@class,'metricsWidget')]//div[@class='input-search-container']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'metricsWidget')]//div[@class='search-result']//ol//li//span[text()='user']")).click();

		// Thread.sleep(5);
		// driver.close();

	}
}
