package br.com.bugbank.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BugBankLoginPage {

    private final WebDriver driver;

    private final By campoEmail = By.cssSelector("input[name='email']");
    private final By campoSenha = By.cssSelector("input[name='password']");
    private final By botaoEntrar = By.cssSelector("button[type='submit']");

    //TODO MAPEAR O CAMPO CORRETAMENTE
    //private final By tituloAreaLogada = By.xpath("//p[contains(text(),'bem vindo ao BugBank')]");
    private final By tituloAreaLogada = By.id("btnExit");

    private final By mensagemContaCriada = By.id("modalText");
   private final By mensagemErro = By.id("modalText");

    public BugBankLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clicarBotaoEntrar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(botaoEntrar));
        (button).click();
    }

    public void preencherLogin(String email, String senha) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoEmail)).sendKeys(email);
        driver.findElement(campoSenha).sendKeys(senha);
    }

    public String obterMensagemErro(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemErro)).getText();
    }

    public String obterTextoTituloLogado() {
        return driver.findElement(tituloAreaLogada).getText();
    }
}
