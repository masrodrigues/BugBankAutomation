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

    // Elementos da página
    private final By botaoRegistrar = By.cssSelector(".ihdmxA");
    private final By campoEmail = By.cssSelector(".style__ContainerFieldInput-sc-s3e9ea-0:nth-child(2) > .input__default");
    private final By campoNome = By.cssSelector(".style__ContainerFieldInput-sc-s3e9ea-0:nth-child(3) > .input__default");
    private final By campoSenha = By.cssSelector(".login__password:nth-child(4) .input__default");
    private final By campoConfirmarSenha = By.cssSelector(".login__password:nth-child(5) .input__default");
    private final By checkboxSaldo = By.id("toggleAddBalance");
    private final By botaoCadastrar = By.cssSelector(".CMabB");
    private final By mensagemSucessoModal = By.id("modalText");
    private final By mensagemErro = By.id("modalText");
    private final By menagemObrigatoria = By.xpath("//p[contains(.,'É campo obrigatório')]");

    // Construtor
    public BugBankRegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Métodos para interagir com a página
    public void clicarNoBotaoRegistrar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(botaoRegistrar)).click();
    }


    public void preencherFormularioCadastro(String email, String nome, String senha) {
        driver.findElement(campoEmail).sendKeys(email);
        driver.findElement(campoNome).sendKeys(nome);
        driver.findElement(campoSenha).sendKeys(senha);
        driver.findElement(campoConfirmarSenha).sendKeys(senha);
    }

    public void marcarCriarContaComSaldo() {
        WebElement checkbox = driver.findElement(checkboxSaldo);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", checkbox);
    }

    public String obterMensagemSucesso() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement mensagemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemSucessoModal));
        return mensagemElement.getText();
    }
    public String obterMensagemErro() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement mensagemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemErro));
        return mensagemElement.getText();
    }

    public String obterMensagemObrigatoria() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement mensagemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(menagemObrigatoria));
        return mensagemElement.getText();
    }

    public void clicarNoBotaoCadastrar() {
        driver.findElement(botaoCadastrar).click();
    }
}
