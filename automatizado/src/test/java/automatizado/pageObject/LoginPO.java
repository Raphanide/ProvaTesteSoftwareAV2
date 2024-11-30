package automatizado.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {
	
	@FindBy(id = "email")
	public WebElement inputEmail;
	
	@FindBy(id = "senha")
	public WebElement inputSenha;
	//padrão do nome da variável: nome do elemento html + o que ele representa
	
	@FindBy(id = "btn-entrar")
	public WebElement buttonEntrar;
	
	@FindBy(css = "form.form-login>div.alert>span")
	public WebElement spanMensagem;
	//OBS: capturar a mensagem funciona por id também

	/**
	 * Construtor padrão para criação de uma nova instância da página de login
	 * @param driver Driver da página de login
	 */
	public LoginPO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String obterMensagem() {
		return this.spanMensagem.getText();
		
	}

}
