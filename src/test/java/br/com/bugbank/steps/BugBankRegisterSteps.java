package br.com.bugbank.steps;

import br.com.bugbank.pages.BugBankRegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class BugBankRegisterSteps extends BaseSteps {

    private BugBankRegisterPage registerPage;

    @Before
    public void setUp() {
        setUpDriver();
    }

    @Dado("Eu estou na página inicial do BugBank")
    public void euEstouNaPaginaInicialDoBugBank() throws InterruptedException {
        driver.get("https://bugbank.netlify.app/");
        registerPage = new BugBankRegisterPage(driver);
        Thread.sleep(7000);
    }

    @Quando("Eu clico no botão Registrar")
    public void euClicoNoBotaoRegistrar() throws InterruptedException {
        registerPage.clicarNoBotaoRegistrar();
        Thread.sleep(5000);
    }

    @E("Clico no botão cadastrar")
    public void euAcessoOBotaoCadastrar() {
        registerPage.clicarNoBotaoCadastrar();
    }

    @E("Eu preencho o formulário com {string}, {string}, {string}")
    public void euPreenchoOFormularioCom(String email, String nome, String senha) throws InterruptedException {
        registerPage.preencherFormularioCadastro(email, nome, senha);
        Thread.sleep(5000);
    }

    @Entao("Eu vejo a mensagem de registro {string}")
    public void euVejoAMensagem(String mensagemEsperada) {
        String mensagemAtual = registerPage.obterMensagemSucesso().trim();

        // Exibe mensagens no console para depuração
        System.out.println("Mensagem atual exibida: '" + mensagemAtual + "'");
        System.out.println("Mensagem esperada (fixa): '" + mensagemEsperada + "'");

        // Expressão regular para validar "A conta <qualquer-numero> foi criada com sucesso"
        String regex = "A conta \\d{3}-\\d foi criada com sucesso";

        // Valida se a mensagem corresponde ao padrão esperado
        Assert.assertTrue("A mensagem exibida não corresponde ao padrão esperado!",
            mensagemAtual.matches(regex));
    }

    @E ("Eu preencho o formulário com campo nome vazio")
    public void euPreenchoOFormularioComCampoNome() {
        registerPage.preencherFormularioCadastro("marco@gmail.com", "", "123");
    }

    @Entao("Eu vejo a mensagem de erro {string}")
    public void euVejoAMensagemDeErro(String mensagemEsperada){
        String mensagemAtual = registerPage.obterMensagemErro().trim();
        Assert.assertEquals("A mensagem exibida não é a esperada!", mensagemEsperada, mensagemAtual);
    }


    @E("Eu preencho o formulário com campo email vazio")
    public void euPreenchoOFormularioComCampoEmailVazio(io.cucumber.datatable.DataTable dataTable){
        java.util.Map<String, String> data = dataTable.asMaps().get(0);
        registerPage.preencherFormularioCadastro("", data.get("nome"), data.get("senha"));
    }

    @Entao("Eu vejo a mensagem de campo obrigatorio {string}")
    public void euVejoAMensagemDeCampoObrigatorio(String mensagemEsperada){
        String mensagemAtual = registerPage.obterMensagemObrigatoria().trim();
        Assert.assertEquals("A mensagem exibida não é a esperada!", mensagemEsperada, mensagemAtual);
    }

    @After
    public void tearDown() {
        tearDownDriver();
    }
}
