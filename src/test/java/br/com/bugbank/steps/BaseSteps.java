package br.com.bugbank.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseSteps {
    // Static permite que o driver seja compartilhado entre outas clssses
    protected static WebDriver driver;

    public static void abrirNavegador() {
        // Selenium Manager
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    public static void fecharNavegador() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}