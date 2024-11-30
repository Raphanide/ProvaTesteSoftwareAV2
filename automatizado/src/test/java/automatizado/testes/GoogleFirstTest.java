package automatizado.testes;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleFirstTest {
	private  WebDriver driver;
	private String URL_BASE = "https://www.google.com.br";
	private String PATH_DRIVER = "src/test/resources/chromedriver.exe";
	
	private void iniciar() {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVER);
		driver = new ChromeDriver(); //chama o chromedriver e inicia o processo
		driver.manage().window().maximize(); //para maximizar o navegador
		driver.get(URL_BASE);
		
	}
	
	@Test
	public void pesquisarNoGoogle() {
		//Montagem do cenário
		iniciar();
		
		//Preparação
		WebElement inputPesquisa = driver.findElement(By.name("q"));
		
		//Execução
		inputPesquisa.sendKeys("Receita de bolo de laranja" + Keys.ENTER);
		
		String resultado = driver.findElement(By.id("rso")).getText();
		
		//Verificação e Análise
		assertTrue(resultado, resultado.contains("bolo de laranja"));
		
		driver.quit(); //para fechar o navegador
		
	}
	
}




