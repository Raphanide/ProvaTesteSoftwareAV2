package automatizado.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdutoPO extends BasePO {


    @FindBy(id="codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "btn-adicionar")
    public WebElement buttonCriar;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

    @FindBy(id = "btn-sair")
    public WebElement buttonSair;

    @FindBy(id = "mensagem")
    public WebElement spanMensagem;

    @FindBy(css = "body>div>div:nth-child(2)>table>tbody>tr>td:nth-child(1)")
    public WebElement tdCodigo;


    /**
     * Construtor base para a criação da fábrica de emelentos (PageFactory)
     *
     * @param driver
     */
    public ProdutoPO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);  // Initialize elements using Page Factory
    }


    public void executarPreencherDadosProduto(String codigo, String nome, String quantidade, String valor, String data) {
        escrever(inputCodigo, codigo);
        escrever(inputNome, nome);
        escrever(inputQuantidade, quantidade);
        escrever(inputValor, valor);
        escrever(inputData, data);
        buttonSalvar.click();

    }

    private void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto + Keys.TAB);

    }

    public String obterMensagem() {
        return spanMensagem.getText();
    }

    public void sair() {
        buttonSair.click();
    }

    public String obterCodigoDaTabela() {
        return tdCodigo.getText();
    }

    /*
     * Método para simular a abertura do modal com um duplo clique no botao "Criar"
     */
    public void abrirModal() {
        buttonCriar.click();
        buttonCriar.click();
    }
}