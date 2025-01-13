package br.com.bugbank.runners;

import io.cucumber.junit.Cucumber; // Classe principal para executar testes com Cucumber no JUnit
import io.cucumber.junit.CucumberOptions; // Permite configurar opções para a execução do Cucumber
import org.junit.runner.RunWith; // Anotação para especificar qual classe de runner será usada

// Especifica que esta classe usará o runner do Cucumber para execução dos testes
@RunWith(Cucumber.class)

// Configurações para a execução dos testes com o Cucumber
@CucumberOptions(
    // Localização dos arquivos de especificação de cenários (features)
    tags = "@login",
    features = "src/test/java/br/com/bugbank/features",

    // Localização dos arquivos de steps, onde estão as implementações dos cenários
    glue = "br.com.bugbank.steps",

    // Configuração de plugins para saída de relatórios e logs
    plugin = {
        "pretty", // Exibe os resultados dos testes de forma legível no console
        "html:target/cucumber-reports.html" // Gera um relatório HTML na pasta target
    },

    // Configuração para exibir as saídas de logs no console sem caracteres desnecessários
    monochrome = true
)
public class TestRunner {
    // Esta classe serve como ponto de entrada para rodar os testes automatizados.
    // Não precisa de métodos ou lógica adicional, pois a execução é controlada pelo Cucumber.
}
