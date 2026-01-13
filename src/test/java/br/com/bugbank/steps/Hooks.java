package br.com.bugbank.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void iniciarNavegador() {
        BaseSteps.abrirNavegador();
    }

    @After
    public void fecharNavegador() {
        BaseSteps.fecharNavegador();
    }
}