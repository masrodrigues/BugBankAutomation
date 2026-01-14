package br.com.bugbank.steps;

import org.junit.Assert;

import br.com.bugbank.pages.BugBankLoginPage;
import br.com.bugbank.pages.BugBankRegisterPage;
import br.com.bugbank.pages.HomePage;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class BugBankLoginSteps extends BaseSteps{

    private BugBankLoginPage loginPage;
    private BugBankRegisterPage registerPage;
    private HomePage homePage;

    @Quando("Eu faço login com email {string} e senha {string}")
    public void euFacoLoginComEmailESenha(String email, String senha){
        if (loginPage == null) loginPage = new BugBankLoginPage(driver);

        loginPage.preencherLogin(email, senha);
        loginPage.clicarBotaoEntrar();
    }

    @Entao("Eu sou redirecionado para a area logada")
    public void euSouRedirecionadoParaAAreaLogada(){
        if (loginPage == null) loginPage = new BugBankLoginPage(driver);

        String textoTitulo = loginPage.obterTextoTituloLogado();
        Assert.assertTrue("Não acessou a Home Page corretamente!",
            textoTitulo.contains("Olá"));
    }

    @Entao("Eu vejo a mensagem de login com erro {string}")
    public void euVejoAMensagemDeLoginComErro(String mensagemEsperada){
        String mensagemAtual = loginPage.obterMensagemErro().trim();
        Assert.assertTrue(mensagemAtual.contains(mensagemEsperada));
    }
}
