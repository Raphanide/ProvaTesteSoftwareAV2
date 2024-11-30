package automatizado.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para a criação das novas PageObjects
 * Todas as PageObjects devem herdar esta classe
 *  
 */


public class BasePO {
	/* Driver base que será usado pelas pages */
	protected WebDriver driver;
	
	/**
	 * Construtor base para a criação da fábrica de emelentos (PageFactory)
	 */
	public BasePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
