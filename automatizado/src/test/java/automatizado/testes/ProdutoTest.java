package automatizado.testes;

import automatizado.pageObject.LoginPO;
import automatizado.pageObject.ProdutoPO;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProdutoTest extends BaseTest {

    private static ProdutoPO produtoPage;

    @BeforeClass
    public static void prepararTestes() {
        // Para direcionar o driver para a pagina de cadastro de produtos
        driver.get("file:///C:/Users/36129382023.2n/Desktop/Prova%20Claytin/sistema/produtos.html");
        produtoPage = new ProdutoPO(driver);
        produtoPage.abrirModal();
    }


    @Test
    public void TC001_naoDevePermitirCadastrarProdutoComTodosOsCamposVazios() {

        produtoPage.executarPreencherDadosProduto("", "", "", "", "");

        String resultado = produtoPage.obterMensagem();

        assertEquals(resultado, "Todos os campos são obrigatórios para o cadastro!");

    }


    @Test
    public void TC002_naoDevePermitirCadastrarProdutoComOCampoNomeVazioETodosOsOutrosCamposPreenchidos() {

        produtoPage.executarPreencherDadosProduto("24", "", "56", "2569", "2012-12-24");

        String resultado = produtoPage.obterMensagem();

        assertEquals(resultado, "Todos os campos são obrigatórios para o cadastro!");

    }


    @Test
    public void TC003_devePermitirCadastrarProdutoComTodosOsCamposPreenchidos() {
        //Definindo uma String para poder identificar o objeto criado na tabela, pois não tinha uma id de produto linkado.
        String idCodigo = "37";

        produtoPage.executarPreencherDadosProduto(idCodigo, "Diogo Nogueira PopFunko", "13", "8001", "1994-12-25");

        // Texto do input de Codigo pós cadastro.
        String codigo = produtoPage.inputCodigo.getText();

        // Texto da primeira linha da tabela na coluna de "Codigo"
        String codigoDaTabela = produtoPage.obterCodigoDaTabela();

        assertEquals(codigo, "");
        assertEquals(codigoDaTabela, idCodigo);
    }
}
