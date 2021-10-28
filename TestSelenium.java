

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
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sheldon\\eclipse-workspace\\SeleniumMaven\\drivers\\chromedriver.exe");

		ChromeDriver driver1 = new ChromeDriver();
		
		driver1 = new ChromeDriver();
		
		driver1.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		driver1.get("https://Google.com");
		
	}
		
	
