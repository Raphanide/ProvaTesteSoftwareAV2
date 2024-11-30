package automatizado.testes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	protected static WebDriver driver;
//	private static final String URL_BASE = "https://www.google.com.br";
	private static final String URL_BASE = "file:///C:/Users/36129382023.2n/Desktop/Prova%20Claytin/sistema/produtos.html";
	private static final String PATH_DRIVER = "src/main/resources/chromedriver.exe";
	
	@BeforeClass
	public static void iniciar() {
		//Montagem do cenário
		System.setProperty("webdriver.chrome.driver", PATH_DRIVER);
		driver = new ChromeDriver(); //chama o chromedriver e inicia o processo
		driver.manage().window().maximize(); //para maximizar o navegador
		driver.get(URL_BASE);
	}
	
//	@AfterClass
//	public static void finalizar() {
//		driver.quit(); //para fechar o navegador
//	}

}
