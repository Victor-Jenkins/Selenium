

import static org.junit.Assert.assertEquals;


import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.*;//importamos todas las clases declaradas en el paq page_objects

//Mantener una estructura y aislar codigo, ordenarlo es esencial para poder luego mantenerlo y entenderlo mucho mejor, 
//por eso lo hacemos mediante metodos que aislan partes de la prueba como un login , o separando las variables de una web a otra mediante clases diferentes.
/*Implementación del Page Object Model
Como hemos mencionado anteriormente, debemos separar los componentes y la lógica de cada página en una clase independiente. De este modo, por ejemplo, la clásica página del buscador de Google podría ser algo similar a:

//estructurando asi los tests podremos reutilizar gran parte de el cambiando solo un
//un par de cosas
//Para ello si vamos a entrar en este caso a 3 paginas , crearemos un nuevo paquete en eclipse donde crearemos las clases, y
//dentro de ellas, pondremos todos los elementos y funciones necesarias en esa web
*/

public class TestSelenium {
	
	WebDriver driver;
	ChromeDriver driver1 = new ChromeDriver();
	//Creamos un metodo que se llama @BeforeEach>beforeTest 
	@BeforeEach
	public void beforeTest() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sheldon\\eclipse-workspace\\SeleniumMaven\\drivers\\chromedriver.exe");

		ChromeDriver driver1 = new ChromeDriver();
		//Aqui vamos a declarar el driver y navegar a la pagina
		driver1 = new ChromeDriver();
		//tiempo de espera
		driver1.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		//Acceder a Google
		driver1.get("https://Google.com");
		
	}
		
	

	@Test//Durante el test se ejecutara esto
	public void duranteTest() {
		
		//en esta funcion vamos a ejecutar las acciones del test
		Google_page google_page = new Google_page(driver);
		//buscar un texto = Wikipedia
		
		google_page.SearchForSomething ("wikipedia");
		
		//recuperar la pagina de resultados
		assertEquals("Wikipedia - Buscar con Google", driver.getTitle());
		//verificaremos que estamos en esa pagina
		//Google_results search_page = Google_result(driver);
		//ir al primer resultado de la busqueda
		//search_page.click_On_First_Result();
		//comprobar el title del articulo bueno de wikipedia
		Wikipedia wikipedia_page = new Wikipedia(driver);
		String articulo_bueno_Title = wikipedia_page.getArticuloBuenoTitle();
		assertEquals("Conferencia de Carnunto", articulo_bueno_Title);	
		
	
	}
	
	



	



	@AfterEach//cuando acabe el test hara esto
	public void afterTest() {
    //aqui eliminaremos el driver y finalizaremos el test	
		
		
		}
	
	

}
