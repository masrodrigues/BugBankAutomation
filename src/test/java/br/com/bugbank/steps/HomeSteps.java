package br.com.bugbank.steps;

import org.junit.Assert;

import br.com.bugbank.pages.HomePage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;


public class HomeSteps extends BaseSteps {

    private HomePage homePage;

    @Dado("que o usuario abre o navegador")
    public void queOUsuarioAbreONavegador(){
        homePage = new HomePage(driver);
        System.out.println("Navegador aberto pelo Hooks.");
    }

    @Quando("o usuario acessa a pagina BugBank")
    public void oUsuarioAcessaAPaginaBugBank(){
        if (homePage == null) homePage = new HomePage(driver);
        homePage.acessarPagina();
    }

    @Entao("a pagina Bugabank é exibida com sucesso")
    public void aPaginaDoBugBankEExibidaComSucesso(){
        if (homePage == null) homePage = new HomePage(driver);

        String textoEsperado = "O banco com bugs e falhas do seu jeito";
        String textoAtual = homePage.obterTextoTitulo();

        Assert.assertTrue("O texto esperado não foi encontrado no título!",
            textoAtual.contains(textoEsperado));
    }
}