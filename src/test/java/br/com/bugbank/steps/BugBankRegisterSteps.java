package br.com.bugbank.steps;

import static br.com.bugbank.steps.BaseSteps.driver;

import org.junit.Assert;

import br.com.bugbank.pages.BugBankRegisterPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class BugBankRegisterSteps {

    private BugBankRegisterPage registerPage;

    @Dado("Eu estou na página inicial do BugBank")
    public void euEstouNaPaginaInicialDoBugBank(){
        driver.get("https://bugbank.netlify.app/");
        registerPage = new BugBankRegisterPage(driver);
    }

    @Quando("Eu clico no botão Registrar")
    public void euClicoNoBotaoRegistrar() {
        registerPage.clicarNoBotaoRegistrar();
    }

    @E("Clico no botão cadastrar")
    public void euAcessoOBotaoCadastrar() {
        registerPage.clicarNoBotaoCadastrar();
    }

    @E("Eu preencho o formulário com {string}, {string}, {string}")
    public void euPreenchoOFormularioCom(String email, String nome, String senha) {
        registerPage.preencherFormularioCadastro(email, nome, senha);
    }

    @Entao("Eu vejo a mensagem de registro {string}")
    public void euVejoAMensagem(String mensagemEsperada) {
        String mensagemAtual = registerPage.obterMensagemSucesso().trim();
        String regex = "A conta \\d{3}-\\d foi criada com sucesso";
        Assert.assertTrue("A mensagem exibida não corresponde ao padrão esperado!",
            mensagemAtual.matches(regex));
    }

    @E ("Eu preencho o formulário com campo nome vazio")
    public void euPreenchoOFormularioComCampoNomeVazio() {
        registerPage.preencherFormularioCadastro("marco@gmail.com", "", "123");
    }

    @Entao("Eu vejo a mensagem de campo obrigatorio {string}")
    public void euVejoAMensagemDeCampoObrigatorio(String mensagemEsperada){
        String mensagemAtual = registerPage.obterMensagemObrigatoria().trim();
        Assert.assertTrue(mensagemAtual.contains(mensagemEsperada));
    }

    @Entao("Eu vejo a mensagem de erro {string}")
    public void euVejoAMensagemDeErro(String mensagemEsperada){
        String mensagemAtual;

        // Lógica de decisão: Se for erro de campo, busca no HTML inline. Se for erro geral, busca no modal.
        if (mensagemEsperada.contains("obrigatório") || mensagemEsperada.contains("inválido")) {
            // Busca o texto vermelhinho embaixo do input
            mensagemAtual = registerPage.obterMensagemValidacaoInline(mensagemEsperada);
        } else {
            // Busca o modal (Pop-up)
            mensagemAtual = registerPage.obterMensagemErroModal();
        }

        System.out.println("Validando erro. Esperado: [" + mensagemEsperada + "] | Encontrado: [" + mensagemAtual + "]");
        Assert.assertTrue(mensagemAtual.contains(mensagemEsperada));
    }
}
