

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
		
	

	@Test//Durante el test se ejecutara esto
	public void duranteTest() {
		
		
		Google_page google_page = new Google_page(driver);
		
		
		google_page.SearchForSomething ("wikipedia");
		
		
		assertEquals("Wikipedia - Buscar con Google", driver.getTitle());
		
		Google_results search_page = Google_result(driver);
		
		search_page.click_On_First_Result();
		
		Wikipedia wikipedia_page = new Wikipedia(driver);
		String articulo_bueno_Title = wikipedia_page.getArticuloBuenoTitle();
		assertEquals("Conferencia de Carnunto", articulo_bueno_Title);	
		
	
	}
	
	


	
	
	

}
