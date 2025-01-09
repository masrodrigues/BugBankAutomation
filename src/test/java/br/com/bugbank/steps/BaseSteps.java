package br.com.bugbank.steps;

import io.github.bonigarcia.wdm.WebDriverManager; // Gerenciador automático de drivers de WebDriver (neste caso, ChromeDriver)
import org.openqa.selenium.WebDriver; // Interface WebDriver, usada para controle do navegador
import org.openqa.selenium.chrome.ChromeDriver; // Implementação do WebDriver para o navegador Google Chrome

public class BaseSteps {

    // Declaração da variável `driver`, que será usada para interagir com o navegador.
    protected WebDriver driver;

    // Metodo para configurar e inicializar o driver do Chrome.
    public void setUpDriver() {
        // Configura o ChromeDriver automaticamente usando o WebDriverManager.
        WebDriverManager.chromedriver().setup();

        // Inicializa o driver como uma nova instância do ChromeDriver.
        driver = new ChromeDriver();

        // Maximiza a janela do navegador para facilitar a visualização e evitar problemas com elementos fora da tela.
        driver.manage().window().maximize();
    }

    // Metodo para encerrar o driver e fechar o navegador.
    public void tearDownDriver() {
        // Verifica se o driver foi inicializado (para evitar erros caso o metodo seja chamado sem inicialização).
        if (driver != null) {
            // Fecha todas as janelas do navegador e encerra a instância do WebDriver.
            driver.quit();
        }
    }
}
