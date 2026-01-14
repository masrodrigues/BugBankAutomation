package br.com.bugbank.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;

    private final By tituloPagina = By.xpath("//h1[contains(text(),'O banco com bugs e falhas do seu jeito')]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Metodo para acessar a página BugBank
    public void acessarPagina() {
        driver.get("https://bugbank.netlify.app/");
    }

    // Metodo para capturar o texto do título principal
    public String obterTextoTitulo() {
        return driver.findElement(tituloPagina).getText();
    }
}
