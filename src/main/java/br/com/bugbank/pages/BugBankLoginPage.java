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

    // Localizadores
    private final By campoEmail = By.cssSelector("input[name='email']");
    private final By campoSenha = By.cssSelector("input[name='password']");
    private final By botaoEntrar = By.cssSelector("button[type='submit']");
    private final By mensagemContaCriada = By.id("modalText");
    private final By mensagemErro = By.id("modalText");

    // Construtor
    public BugBankLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Métodos
    public void preencherLogin(String email, String senha) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoEmail)).sendKeys(email);
        driver.findElement(campoSenha).sendKeys(senha);
    }

    public void clicarBotaoEntrar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(botaoEntrar));

        // Clique via JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }




    public String obterMensagemDeSucesso() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemContaCriada)).getText();
    }


    public String obterMensagemErro() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemErro)).getText();
    }
}
