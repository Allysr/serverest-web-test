package br.com.serveRest.pages;

import br.com.serveRest.util.AguardarElemento;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastrarUsuarioPage {
    private WebDriver driver;
    private AguardarElemento espera;

    private By botaoCadastrar = By.linkText("Cadastre-se");
    private By botaoConcluirCadastro = By.cssSelector(".btn-primary");
    private By campoNome = By.id("nome");
    private By campoEmail = By.id("email");
    private By campoSenha = By.id("password");
    private By checkBoxAdministrador = By.id("administrador");

    public CadastrarUsuarioPage(WebDriver driver) {
        this.driver = driver;
        this.espera = new AguardarElemento(driver);
    }

    public CadastrarUsuarioPage clicarBotaoCadastrar() {
        espera.aguardarElemento(botaoCadastrar).click();
        return this;
    }

    public CadastrarUsuarioPage preencherNome(String nome) {
        espera.aguardarElemento(campoNome).sendKeys(nome);
        return this;
    }

    public CadastrarUsuarioPage preencherEmail(String email) {
        espera.aguardarElemento(campoEmail).sendKeys(email);
        return this;
    }

    public CadastrarUsuarioPage preencherSenha(String senha) {
        espera.aguardarElemento(campoSenha).sendKeys(senha);
        return this;
    }

    public CadastrarUsuarioPage marcarAdministrador() {
        espera.aguardarElemento(checkBoxAdministrador).click();
        return this;
    }

    public CadastrarUsuarioPage clicarConcluirCadastro() {
        espera.aguardarElemento(botaoConcluirCadastro).click();
        return this;
    }

}


