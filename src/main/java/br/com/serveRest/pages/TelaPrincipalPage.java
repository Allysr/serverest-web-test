package br.com.serveRest.pages;

import br.com.serveRest.util.AguardarElemento;
import br.com.serveRest.util.CapturarImagem;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TelaPrincipalPage {
    private WebDriver driver;
    private AguardarElemento espera;

    private By mensagemBoasVindas = By.tagName("h1");
    private By botaoDeslogar = By.cssSelector("[data-testid='logout']");
    private By botaoCadastrarProduto = By.cssSelector("[data-testid='cadastrarProdutos']");

    public TelaPrincipalPage (WebDriver driver) {
        this.driver = driver;
        this.espera = new AguardarElemento(driver);
    }

    public TelaPrincipalPage clicarBotaoDeslogar(){
        espera.aguardarElemento(botaoDeslogar).click();
        return this;
    }

    public TelaPrincipalPage clicarBotaoCadastrarProduto(){
        espera.aguardarElemento(botaoCadastrarProduto).click();
        return this;
    }

    public TelaPrincipalPage validarMensagemBoasVindas(String mensagemEsperada) {
        CapturarImagem.capturarImagem(driver, "validar-mensagem-boas-vindas");
        String mensagem = espera.aguardarElemento(mensagemBoasVindas).getText();
        Assertions.assertEquals(mensagemEsperada, mensagem);
        return this;
    }
}