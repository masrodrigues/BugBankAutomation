package br.com.bugbank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    // Defina quais testes rodar. Use "not @ignore" para rodar tudo que não estiver ignorado
    // Ou use tags = "@login or @Registro" para rodar os dois
    tags = "@Registro",

    features = "src/test/java/br/com/bugbank/features",
    glue = "br.com.bugbank.steps",

    // GERAÇÃO DE RELATÓRIOS
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber-reports.json" // Útil se quiser integrar com Jenkins depois
    },

    monochrome = true,

    // IMPORTANTE: Faz o Cucumber sugerir métodos no padrão Java (camelCase)
    snippets = CucumberOptions.SnippetType.CAMELCASE

)
public class TestRunner {
}