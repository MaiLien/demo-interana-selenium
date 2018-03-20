package BlueOtter.Interana;

public class demo {
	
public static void main(String[] args) throws InterruptedException {
		
//		System.setProperty("webdriver.gecko.driver", ".\\gecko\\v0.19.0\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
//        driver.get("http://demo.guru99.com/selenium/deprecated.html");
//        driver.switchTo().frame("classFrame");
//        driver.findElement(By.linkText("Deprecated")).click();
//		
//		driver.close();
		
	String a = "abc%s";
	String b = String.format(a, "567");
	System.out.println(b);
		
		
	}

}
