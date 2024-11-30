package automatizado.testes;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizado.pageObject.LoginPO;

public class LoginTest extends BaseTest{

	private static LoginPO loginPage;

	@BeforeClass
	public static void prepararTestes() {
		loginPage = new LoginPO(driver);
	}

	@Test
	public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazio() {
		loginPage.inputEmail.sendKeys("");
		loginPage.inputSenha.sendKeys("");

		loginPage.buttonEntrar.click();

		String mensagem = loginPage.obterMensagem();

		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

	}

	@Test
	public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazio() {
		loginPage.inputEmail.sendKeys("");
		loginPage.inputSenha.sendKeys("teste123");
		
		loginPage.buttonEntrar.click();
		
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
	}

}
