package br.com.serveRest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static br.com.serveRest.configuracoes.GerenciamentoDriver.configurarDriver;
import static br.com.serveRest.configuracoes.LeitorDePropriedades.lerPropriedades;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void iniciarDriver(){
        driver = configurarDriver(lerPropriedades("navegador"));
        driver.get(lerPropriedades("url"));
    }

    @AfterEach
    void fecharDriver(){
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Finalizando teste");
    }
}
