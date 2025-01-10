package br.com.bugbank.steps;

import br.com.bugbank.pages.HomePage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;

public class HomeSteps extends BaseSteps {

    // Instância da página inicial do sistema (HomePage)
    private HomePage homePage;

    /**
     * Este metodo inicializa o WebDriver (navegador) e a página inicial do sistema.
     */
    @Dado("que o usuário abre o navegador")
    public void queOUsuarioAbreONavegador() {
        // Configuração do WebDriver e inicialização
        setUpDriver();
        // Instancia a classe HomePage, vinculando-a ao WebDriver
        homePage = new HomePage(driver);
    }

    /**
     * Este metodo faz o navegador acessar a URL do sistema BugBank.
     */
    @Quando("o usuário acessa a página BugBank")
    public void oUsuarioAcessaAPaginaBugBank() throws InterruptedException {

        // Chama o método da HomePage para acessar a URL principal do sistema
        homePage.acessarPagina();
    }

    /**
     * Este metodo valida que a página foi carregada com sucesso e encerra o navegador.
     */
    @Entao("a página BugBank é exibida com sucesso")
    public void aPaginaBugBankEExibidaComSucesso() {
        // Valida que o título "O banco com bugs e falhas do seu jeito" está presente
        String textoEsperado = "O banco com bugs e falhas do seu jeito";
        String textoAtual = homePage.obterTextoTitulo();

        // Verifica se o texto atual contém o texto esperado
        Assert.assertEquals("O texto da página não corresponde ao esperado!", textoEsperado, textoAtual);

        // Exibe uma mensagem no console indicando que a validação foi bem-sucedida
        System.out.println("Validação concluída: Texto encontrado na página.");

        // Encerra o WebDriver e fecha o navegador
        tearDownDriver();
    }
}
