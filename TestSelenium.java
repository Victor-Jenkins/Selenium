

import static org.junit.Assert.assertEquals;


import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.*;

public class TestSelenium {
	
	WebDriver driver;
	ChromeDriver driver1 = new ChromeDriver();
	
	@BeforeEach
	public void beforeTest() {
		
		System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); 
		WebDriver driver = new ChromeDriver(); 

  		driver.get("http://www.google.com/"); 
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		driver.get("https://Google.com");
		
	}
		
	
