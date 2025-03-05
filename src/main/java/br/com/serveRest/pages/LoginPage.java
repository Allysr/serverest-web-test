package br.com.serveRest.pages;

import br.com.serveRest.util.AguardarElemento;
import br.com.serveRest.util.CapturarImagem;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private AguardarElemento espera;

    private By campoEmail = By.id("email");
    private By campoSenha = By.id("password");
    private By botaoLogin = By.cssSelector("[data-testid='entrar']");
    private By titulo = By.tagName("h1");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        espera = new AguardarElemento(driver);
    }

    public LoginPage preencherEmail(String email) {
        espera.aguardarElemento(campoEmail).sendKeys(email);
        return this;
    }

    public LoginPage preencherSenha(String senha) {
        espera.aguardarElemento(campoSenha).sendKeys(senha);
        return this;
    }

    public LoginPage clicarLogin() {
        espera.aguardarElemento(botaoLogin).click();
        return this;
    }

    public LoginPage validarTituloPagina(String mensagemEsperada) {
        String mensagem = espera.aguardarElemento(titulo).getText();
        Assertions.assertEquals(mensagemEsperada, mensagem);
        CapturarImagem.capturarImagem(driver, "validar-titulo-pagina");
        return this;
    }
}
