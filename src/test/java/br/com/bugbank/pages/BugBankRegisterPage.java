package br.com.bugbank.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BugBankRegisterPage {

    private final WebDriver driver;

    private final By botaoRegistrar = By.xpath("//button[contains(text(), 'Registrar')]");

    // Inputs mapeados pelo 'name'
    private final By campoEmail = By.xpath("//div[contains(@class, 'card__register')]//input[@name='email']");
    private final By campoNome = By.xpath("//div[contains(@class, 'card__register')]//input[@name='name']");
    private final By campoSenha = By.xpath("//div[contains(@class, 'card__register')]//input[@name='password']");
    private final By campoConfirmarSenha = By.xpath(
        "//div[contains(@class, 'card__register')]//input[@name='passwordConfirmation']");

    private final By checkboxSaldo = By.id("toggleAddBalance");
    private final By botaoCadastrar = By.xpath("//button[contains(text(), 'Cadastrar')]");

    // MENSAGENS E MODAIS
    private final By mensagemSucessoModal = By.id("modalText");
    private final By mensagemErroModal = By.id("modalText");
    private final By botaoFecharModal = By.id("btnCloseModal");

    private final By mensagemErroInlineGenerica = By.xpath("//p[@class='input__warging' or contains(@class, 'input__warning')]");

    public BugBankRegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clicarNoBotaoRegistrar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.elementToBeClickable(botaoRegistrar)).click();
    }

    public void preencherFormularioCadastro(String email, String nome, String senha) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoEmail)).sendKeys(email);

        driver.findElement(campoNome).sendKeys(nome);
        driver.findElement(campoSenha).sendKeys(senha);
        driver.findElement(campoConfirmarSenha).sendKeys(senha);
    }

    public void marcarCriarContaComSaldo() {
        WebElement checkbox = driver.findElement(checkboxSaldo);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", checkbox);
    }

    public void clicarNoBotaoCadastrar() {
        // Forçar clique via JS ajuda se o botão estiver parcialmente coberto
        WebElement btn = driver.findElement(botaoCadastrar);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    public void fecharModal() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.elementToBeClickable(botaoFecharModal)).click();
        } catch (Exception e) {
            // Se o modal não estiver aberto, apenas ignora
        }
    }

    public String obterMensagemSucesso() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemSucessoModal)).getText();
    }


    public String obterMensagemObrigatoria() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemErroInlineGenerica)).getText();
    }

    public String obterMensagemErroModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemErroModal)).getText();
    }

    // --- NOVO: Busca erro direto no HTML (texto vermelho abaixo do campo) ---
    public String obterMensagemValidacaoInline(String textoEsperado) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Estratégia Dinâmica: Procura um parágrafo <p> que contenha exatamente o texto que passamos no teste
        By locatorTextoEspecifico = By.xpath("//p[contains(text(), '" + textoEsperado + "')]");

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locatorTextoEspecifico)).getText();
    }
}
