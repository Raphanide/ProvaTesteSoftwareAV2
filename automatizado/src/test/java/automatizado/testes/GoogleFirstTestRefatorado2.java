package automatizado.testes;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;

import automatizado.pageObject.GooglePO;


public class GoogleFirstTestRefatorado2 extends BaseTest{
	
	private static GooglePO googlePage;
	
	@BeforeClass
	public static void prepararTestes() {
		driver.get("https://www.google.com");
		googlePage = new GooglePO(driver);
	}
	
	@Test
	public void pesquisarNoGoogle() {
		//Classe implementada com a separação de camada de camada. A parte de página está no PO
		
		//Montagem do cenário agora é feita quando são chamados: 
		//@BeforeClass
		//iniciar()
		
		//Preparação - não é mais necessário, está no PO
		//WebElement inputPesquisa = driver.findElement(By.name("q"));
		
		//Execução
		//inputPesquisa.sendKeys("Receita de bolo de laranja" + Keys.ENTER);
		googlePage.inputPesquisa.sendKeys("Receita de bolo de laranja" + Keys.ENTER);
		
		
		//String resultado = driver.findElement(By.id("rso")).getText();
		String resultado = googlePage.divResultadoPesquisa.getText();
		
		//Verificação e Análise
		assertTrue(resultado, resultado.contains("bolo de laranja"));
		assertTrue(resultado.toLowerCase(), resultado.contains("Bolo de Laranja".toLowerCase()));		
	}
	
	@Test
	public void pesquisarNoGoogle2() {
		googlePage.inputPesquisa.sendKeys("Receita de bolo de laranja" + Keys.ENTER);
		
		String resultado = googlePage.divResultadoPesquisa.getText();

		assertTrue(resultado, resultado.contains("bolo de laranja"));
		assertTrue(resultado.toLowerCase(), resultado.contains("Bolo de Laranja".toLowerCase()));
				
	}
	
	
	
}




