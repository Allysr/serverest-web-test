package br.com.serveRest.pages;

import br.com.serveRest.util.AguardarElemento;
import br.com.serveRest.util.CapturarImagem;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListarProdutosPage {
    private WebDriver driver;
    private AguardarElemento espera;

    private By tituloProdutos = By.tagName("h1");

    public ListarProdutosPage(WebDriver driver){
        this.driver = driver;
        espera = new AguardarElemento(driver);
    }

    public ListarProdutosPage validarPaginaListarProdutos() {
        String titulo = espera.aguardarElemento(tituloProdutos).getText();
        Assertions.assertEquals("Lista dos Produtos", titulo);
        CapturarImagem.capturarImagem(driver, "lista-dos-produtos");
        return this;
    }
}
