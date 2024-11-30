package automatizado.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO{
	
	/*	PageFactory: injeta em tempo de execução (cria dinamicamente) uma lógica de teste
	da classe de teste que instancia GooglePO, no caso GoogleTestRefatorado2
	O elemento/código que cria a factory está em BasePO (PageFactory.initElements(driver, this))
	que é herdada por Google PO	*/
	
	@FindBy(name = "q")
	public WebElement inputPesquisa;
	
	@FindBy(id = "rso")
	public WebElement divResultadoPesquisa;
	
	/**
	 * Construtor para criação da página no Google
	 * @param driver (Driver da página do Google)
	 */
	public GooglePO(WebDriver driver) {
		super(driver);
	}
	
	
	//****************************para GoogleFirstTestRefatorado3: máximo de isolamento****************************//
	
	
	/**
	 * Método que irá efetuar uma pesquisa no Google baseado no texto
	 * @param texto a ser pesquisado
	 */
	public void pesquisar(String texto) {
		inputPesquisa.sendKeys(texto + Keys.ENTER);
	}
	
	/**
	 * Método que retorna o resultado da pesquisa
	 * @return Retorna o resultado da pesquisa
	 */
	public String getResultadoDaPesquisa() {
		return divResultadoPesquisa.getText();
	}
	
}
