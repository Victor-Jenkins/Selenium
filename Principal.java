import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.thoughtworks.qdox.model.JavaModel;





public class Principal {

	
		
		/**
		 * Esta clase define un doble click en un elemento seleccionado
		 * 
		 * @param element Objeto de tipo WebDriver en el cual se realizará la acción
		 */
		public void doubleClick(WebElement element) {
			String msg;

			try {
				WebDriver driver;
				Actions actions = new Actions(driver);
				actions.moveToElement(element).doubleClick().perform();
				msg = ("[ OK ][" + Thread.currentThread().getStackTrace()[1].getClassName() + "]" + "["
						+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + "["
						+ this.getClass().getSimpleName() + "]" + ": Double Click: "
						+ JavaModel.elementToStringHTML(element.toString()));

			} catch (Exception e) {
				msg = ("[ ERROR ][" + Thread.currentThread().getStackTrace()[1].getClassName() + "]" + "["
						+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + "["
						+ this.getClass().getSimpleName() + "]" + ": Fail Double Click: " + e.getMessage());

			}
			
			/**
			 * Realiza un scroll hacia abajo hasta el elemento indicado
			 * 
			 * @param element Objeto de tipo WebDriver en el cual se realizará la acción
			 */
			public void scrollTo(WebElement element14) {

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element14);
			}

			/***
			 * Método para seleccionar una opcion de un desplegable con texto visible
			 * 
			 * @param element    Objeto de tipo WebDriver en el cual se realizará la acción
			 * @param txtvisible Texto a buscar en las opciones
			 */
			public void selectSamples(WebElement element99, String txtvisible) Object framework;
			{
				String msg1;

				try {
					Select sel = new Select(element99);
					sel.selectByVisibleText(txtvisible);
					msg1 = ("[ OK ][" + Thread.currentThread().getStackTrace()[1].getClassName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + "["
							+ this.getClass().getSimpleName() + "]" + ": Select: " + txtvisible + " in "
							+ framework.selenium.common.config.JavaHTML.elementToStringHTML(element99.toString()));

				} catch (Exception e) {
					msg1 = ("[ ERROR ][" + Thread.currentThread().getStackTrace()[1].getClassName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + "["
							+ this.getClass().getSimpleName() + "]" + ": Fail Select: " + txtvisible + " in " + e.getMessage());

				}
				framework.selenium.common.config.Log.register(msg1);
			}

			/**
			 * Método para seleccionar de un desplegable pasandole el id y el index
			 * 
			 * @param id    ID del elemento WebDriver
			 * @param index Indice ordenado a seleccionar
			 */
			public void selectByIndex(String id, int index) {
				String msg;

				try {
					WebElement testDropDown = driver.findElement(By.id(id));
					Select dropdown = new Select(testDropDown);
					dropdown.selectByIndex(index);
					msg = ("[ OK ][" + Thread.currentThread().getStackTrace()[1].getClassName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + "["
							+ this.getClass().getSimpleName() + "]" + ": Select: " + index + " in "
							+ framework.selenium.common.config.JavaHTML.elementToStringHTML(testDropDown.toString()));

				} catch (Exception e) {
					msg = ("[ ERROR ][" + Thread.currentThread().getStackTrace()[1].getClassName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + "["
							+ this.getClass().getSimpleName() + "]" + ": Fail Select: " + index + " in " + e.getMessage());

				}
				framework.selenium.common.config.Log.register(msg);
			}

			/**
			 * Método para seleccionar de un desplegable pasandole el elemento y el valor
			 * 
			 * @param element Objeto de tipo WebDriver en el cual se realizará la acción
			 * @param value   Valor del elemento a seleccionar
			 */
			public void selectByValue(WebElement element, String value) {
				String msg;

				try {
					Select dropdown = new Select(element);
					dropdown.selectByValue(value);
					msg = ("[ OK ][" + Thread.currentThread().getStackTrace()[1].getClassName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + "["
							+ this.getClass().getSimpleName() + "]" + ": Select: " + value + " in "
							+ framework.selenium.common.config.JavaHTML.elementToStringHTML(element.toString()));

				} catch (Exception e) {
					msg = ("[ ERROR ][" + Thread.currentThread().getStackTrace()[1].getClassName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + "["
							+ this.getClass().getSimpleName() + "]" + ": Fail Select: " + value + " in " + e.getMessage());

				}
				framework.selenium.common.config.Log.register(msg);
			}

			/**
			 * Cambia la ventana actual por otra ventana de la sesion
			 */
			public void switchWindow() {
				String msg;

				try {
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
						driver.manage().window().maximize();
					}
					msg = ("[ OK ][" + Thread.currentThread().getStackTrace()[1].getClassName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + ": Switch window: "
							+ driver.getCurrentUrl());

				} catch (Exception e) {
					msg = ("[ ERROR ][" + Thread.currentThread().getStackTrace()[1].getClassName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + ": Fail Switch window: "
							+ driver.getCurrentUrl() + ", " + e.getMessage());

				}
				framework.selenium.common.config.Log.register(msg);
			}
			/**
			 * Cambia entre frame dentro de la pagina web Cuando un elemento esta dentro de
			 * una etiqueta iframe hay que acceder a ese iframe para poder obtener e
			 * interactuar con el objeto o elemento Un vez que ya no se tenga que
			 * interactuar con el objeto hay que volver al iframe parent
			 * 
			 * @param frameId Define la ruta por ID del iframe
			 */
			public void switchFrame(String frameId) {
				String msg;

				try {
					WebDriverWait wait = new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
							driver.findElement(By.xpath(String.format("//*[@name='%1$s' or @id='%1$s']", frameId)))));
					/*
					 * getDriver().switchTo() .frame(driver.findElement(By.xpath(String.
					 * format("//*[@name='%1$s' or @id='%1$s']", frameId))));
					 */
					msg = ("[ OK ][" + Thread.currentThread().getStackTrace()[1].getClassName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + ": Successful switch frame.");
					framework.selenium.common.config.Log.register(msg);
				} catch (Exception e) {
					msg = ("[ ERROR ][" + Thread.currentThread().getStackTrace()[1].getClassName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + ": Unsuccessful switch frame."
							+ e.getMessage());
					framework.selenium.common.config.Log.register(msg);
					getIframes();
				}

			}

			public void switchNextFrame() {
				List<WebElement> frames = getIframes();
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frames.get(0)));
			}

			/**
			 * Muestra los frames y iframes dentro de la pagina web
			 */
			public List<WebElement> getIframes() {
				driver.switchTo().defaultContent();
				frames.clear();
				frames.addAll(driver.findElements(By.xpath("//frame")));
				frames.addAll(driver.findElements(By.xpath("//iframe")));
				System.out.println("Number of frames in a page :" + frames.size());
				for (WebElement el : frames) {
					// Returns the Id of a frame.
					System.out.println("Frame Id :" + el.getAttribute("id") + " \tFrame name :" + el.getAttribute("name"));
				}
				return frames;
			}

			/**
			 * Refresca la pantalla del navegador
			 */
			public void refreshBrowser() {
				String msg;

				try {
					driver.navigate().refresh();
					msg = ("[ OK ][" + Thread.currentThread().getStackTrace()[1].getClassName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + ": Refresh success");

				} catch (Exception e) {
					msg = ("[ ERROR ][" + Thread.currentThread().getStackTrace()[1].getClassName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + ": Could not refresh browser: "
							+ e.getMessage());

				}

				framework.selenium.common.config.Log.register(msg);
			}
			/**
			 * Metodo para generar DNI valido y Email Se guardan en variable global por lo
			 * que luego son reutilizables despues de generarlos
			 */
			public final void generateDNI() {
				int num = 0;
				Random rnd = new Random();
				rnd.setSeed(System.currentTimeMillis());
				num = 10000000 + rnd.nextInt(90000000);

				int resto = 0;
				String letra = "";
				resto = num % 23;
				letra = "" + asigLetra.charAt(resto);

				dni = num + letra;
				email = dni + "@yopmail.com";
				System.out.println(dni + " <-|-> " + email);
			}
		

			/**
			 * Metodo para generar NIE valido Se guardan en variable global por lo que luego
			 * son reutilizables despues de generarlos
			 */
			public static void generateNIE() {
				Random rnd = new Random();
				rnd.setSeed(System.currentTimeMillis());
				String[] letraNIE = { "X", "Y", "Z" };
				int numNIE = rnd.nextInt(2);
				int num = 1000000 + rnd.nextInt(9000000);
				int resto = Integer.parseInt(String.valueOf(numNIE) + String.valueOf(num)) % 23;
				nie = letraNIE[numNIE] + num + asigLetra.charAt(resto);
			}

			/**
			 * Metodo para obtener el dni del metodo generateDNI()
			 * 
			 * @return DNI generado en @see generateDNI
			 */
			public static String getDNI() {
				return dni;
			}

			/**
			 * Metodo para obtener el nie del metodo generateNIE()
			 * 
			 * @return NIE generado en @see generateNIE
			 */
			public static String getNIE() {
				return nie;
			}

			/**
			 * Metodo para obtener el email del metodo generateDNI()
			 * 
			 * @return E-mail generado en @see generateDNI
			 */
			public static String getMAIL() {
				return email;
			}

			/**
			 * Metodo para obtener el email del generado a través de la fecha y hora
			 * actuales
			 * 
			 * @return E-mail generado
			 */
			public String getMAILDate() {
				return fechaFormat("dd/MM/yyyy").replace("/", "") + getHora().replace(":", "") + "@yopmail.com";
			}

			public void wait(int secs) {
				String msg;
				try {
					Thread.sleep(secs * 1000);
					msg = ("[ OK ] " + ": Espera de " + secs + " realizada.");

				} catch (Exception ex) {
					msg = ("[ ERROR ] " + ": Error al realizar la espera.");

				}
				framework.selenium.common.config.Log.register(msg);
			}

			/**
			 * /** Metodo para esperar hasta que un elemento sea visible
			 * 
			 * @param element Elemento al que se esta esperando hasta que sea visible
			 */
			public void wait(WebElement element) {
				String msg;

				try {
					WebDriverWait wait = new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions.visibilityOf(element));
				} catch (Exception e) {
					msg = ("[ ERROR ][" + Thread.currentThread().getStackTrace()[1].getClassName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + ": Element not is visibility: "
							+ e.getMessage());

					framework.selenium.common.config.Log.register(msg);
				}
			}

			/**
			 * /** Metodo para esperar hasta que un elemento sea visible y clickar sobre él
			 * 
			 * @param element Elemento al que se esta esperando hasta que sea visible y se
			 *                realiza su click
			 */
			public void waitClick(WebElement element) {
				String msg;

				try {
					wait(1);
					wait(element);
					click(element);
				} catch (Exception e) {
					msg = ("[ ERROR ][" + Thread.currentThread().getStackTrace()[1].getClassName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + "["
							+ Thread.currentThread().getStackTrace()[1].getMethodName() + "]" + ": Element not is visibility: "
							+ e.getMessage());
					framework.selenium.common.config.Log.register(msg);
				}
			}
			
			/**
			 * Genera un CIF a partir de un numero aleatorio y calcula su digito de control
			 * 
			 * @return String con el CIF
			 */
			public String getCIF() {
				int numAleatorio = (int) (Math.random() * 9999999) + 1;
				char letra = letrasCif.charAt((int) (Math.random() * letrasCif.length()));
				String cif = letra + String.format("%07d", numAleatorio);
				return cif + calculaDigitoControl(cif);
			}

			public String GeneraliEntorno(String entorno) {
				switch (entorno) {
				case "3":
					return "https://www.generali.es";
				case "4":
					return "https://www.test.generali.es";
				default:
				case "6":
					return "https://www.user.generali.es";
				case "8":
					return "https://www.prep.generali.es";
				}
			}

			/**
			 * Genera una matricula con el formato DiaMes*XXX siendo X una letra generada al azar
			 * @return
			 */
			public String getMatricula() {
				String numeracion = getDiaHoy() + getMesHoy();
				char letra1 = letrasMatricula.charAt((int) (Math.random() * letrasMatricula.length()));
				char letra2 = letrasMatricula.charAt((int) (Math.random() * letrasMatricula.length()));
				char letra3 = letrasMatricula.charAt((int) (Math.random() * letrasMatricula.length()));
				return numeracion + "*" + letra1 + letra2 + letra3;
			}

			/**
			 * Genera un telefono aleatorio con los parametros indicados
			 * 
			 * @param internacional es internacional ? añade el prefijo "0034"
			 * @param fijo          fijo o movil => true/false
			 * @return
			 */
			public String getTelefono(boolean internacional, boolean fijo) {
				String telf = "", prefix = "";
				Random rand = new Random();
				prefix = internacional ? "0034" : "";
				telf = fijo ? prefix + (800000000 + rand.nextInt((999999999) - 800000000))
						: prefix + (600000000 + rand.nextInt((799999999) - 600000000));
				System.out.println("TELF: " + telf);
				return telf;
			}

			/**
			 * Calcula el digito de control del CIF
			 * 
			 * @param cif
			 * @return
			 */

			private String calculaDigitoControl(String cif) {
				String str = cif.substring(1, 8);
				String cabecera = cif.substring(0, 1);
				int sumaPar = 0;
				int sumaImpar = 0;
				int sumaTotal;

				for (int i = 1; i < str.length(); i += 2) {
					int aux = Integer.parseInt("" + str.charAt(i));
					sumaPar += aux;
				}

				for (int i = 0; i < str.length(); i += 2) {
					sumaImpar += posicionImpar("" + str.charAt(i));
				}

				sumaTotal = sumaPar + sumaImpar;
				sumaTotal = 10 - (sumaTotal % 10);

				if (sumaTotal == 10) {
					sumaTotal = 0;
				}

				if (cifLetra.contains(cabecera)) {
					str = "" + digitoControlCif.charAt(sumaTotal);
				} else {
					str = "" + sumaTotal;
				}

				return str;
			}

			private int posicionImpar(String str) {
				int aux = Integer.parseInt(str);
				aux = aux * 2;
				aux = (aux / 10) + (aux % 10);

				return aux;
			}

			// obetener numero de referencia de factura
//			TODO Eliminar y reemplazar con getFullFecha en la declaración de código implementado
			public String getRefenfactura() {
				Date date = new Date();
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				return dateFormat.format(date);
			}

			/**
			 * Comprueba la descarga del fichero <filename> en la ruta predeterminada por downloadDir y lo elimina si lo encuentra, en caso contrario lanza una IOException
			 * @param filename Archivo a buscar
			 * @throws IOException Archivo no encontrado
			 */
			public void comprobacionFichero(String filename) throws IOException {
				WebDriverWait wait = new WebDriverWait(driver, 20);
				System.out.println("Searching file ..." + downloadDir + "\\" + filename);
				assertTrue(wait.until(x -> new File(downloadDir + "\\" + filename).exists()),
						"No se ha encontrado el fichero descargado");
				wait(3);
				web(downloadDir + "\\" + filename);
				wait(5);
				Reporter.log("Archivo descargado correctamente:" + downloadDir + "\\" + filename);

				if (!Files.deleteIfExists((Paths.get(downloadDir + "\\" + filename)))) {
					System.out.println("El archivo descargado no se ha elininado correctamente");
					Reporter.log("El archivo descargado no se ha elininado correctamente");
				}
			}
	}

}
