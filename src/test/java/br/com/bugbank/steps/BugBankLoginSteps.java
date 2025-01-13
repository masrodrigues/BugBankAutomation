package br.com.bugbank.steps;

import br.com.bugbank.pages.BugBankLoginPage;
import br.com.bugbank.pages.BugBankRegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;

public class BugBankLoginSteps extends BaseSteps {

    private BugBankLoginPage loginPage;

    @Before
    public void setUp() {
        setUpDriver();
        loginPage = new BugBankLoginPage(driver);
    }

    @Dado("Eu estou na página de login do BugBank")
    public void euEstouNaPaginaDeLoginDoBugBank() {
        driver.get("https://bugbank.netlify.app/");
    }
    @E("Eu crio uma conta de teste com email {string}, nome {string} e senha {string}")
    public void euCrioUmaContaDeTeste(String email, String nome, String senha) {
        BugBankRegisterPage registerPage = new BugBankRegisterPage(driver);
        registerPage.clicarNoBotaoRegistrar();
        registerPage.preencherFormularioCadastro(email, nome, senha);
        registerPage.clicarNoBotaoCadastrar();

        // Aguarda e valida a mensagem de criação de conta
        String mensagemSucesso = registerPage.obterMensagemSucesso();
        System.out.println("Conta criada com sucesso: " + mensagemSucesso);
        Assert.assertTrue(mensagemSucesso.contains("A conta"));
    }
    @Quando("Eu faço login com email {string} e senha {string}")
    public void euFacoLoginComEmailESenha(String email, String senha) {
        loginPage.preencherLogin(email, senha);
        loginPage.clicarBotaoEntrar();
    }

    @Entao("Eu vejo a mensagem de login com erro {string}")
    public void euVejoAMensagemDeLoginComErro(String mensagemEsperada) {
        String mensagemAtual = loginPage.obterMensagemErro().trim();

        // Exibe mensagens no console para depuração
        System.out.println("Mensagem atual exibida: '" + mensagemAtual + "'");
        System.out.println("Mensagem esperada: '" + mensagemEsperada + "'");

        Assert.assertTrue("A mensagem exibida não contém a mensagem esperada!",
            mensagemAtual.contains(mensagemEsperada));
    }
    @Entao("Eu vejo a mensagem sucesso {string}")
    public void euVejoAMensagemDeBoasVindas(String mensagemEsperada) {
        String mensagemAtual = loginPage.obterMensagemDeSucesso().trim();

        // Exibe mensagens no console para depuração
        System.out.println("Mensagem atual exibida: '" + mensagemAtual + "'");
        System.out.println("Mensagem esperada: '" + mensagemEsperada + "'");

        String regex = "A conta \\d{3}-\\d foi criada com sucesso";

        // Valida se a mensagem corresponde ao padrão esperado
        Assert.assertTrue("A mensagem exibida não corresponde ao padrão esperado!",
            mensagemAtual.matches(regex));
    }


    @After
    public void tearDown() {
        tearDownDriver();
    }
}
