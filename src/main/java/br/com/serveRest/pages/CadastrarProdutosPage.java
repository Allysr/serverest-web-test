package br.com.serveRest.pages;

import br.com.serveRest.util.AguardarElemento;
import br.com.serveRest.util.CapturarImagem;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastrarProdutosPage {
    private WebDriver driver;
    private AguardarElemento espera;

    private By campoNome = By.id("nome");
    private By campoPreco = By.id("price");
    private By campoDescricao = By.id("description");
    private By campoQuantidade = By.id("quantity");
    private By campoImagem = By.id("imagem");
    private By botaoCadastrar = By.cssSelector("[data-testid='cadastarProdutos']");
    private By tituloProdutos = By.tagName("h1");

    public CadastrarProdutosPage(WebDriver driver){
        this.driver = driver;
        espera = new AguardarElemento(driver);
    }

    public CadastrarProdutosPage preencherNome(String nome) {
        espera.aguardarElemento(campoNome).sendKeys(nome);
        return this;
    }

    public CadastrarProdutosPage preencherPreco(String preco) {
        espera.aguardarElemento(campoPreco).sendKeys(preco);
        return this;
    }

    public CadastrarProdutosPage preencherDescricao(String descricao) {
        espera.aguardarElemento(campoDescricao).sendKeys(descricao);
        return this;
    }

    public CadastrarProdutosPage preencherQuantidade(String quantidade) {
        espera.aguardarElemento(campoQuantidade).sendKeys(quantidade);
        return this;
    }

    public CadastrarProdutosPage enviarImagem(String caminhoImagem) {
        espera.aguardarElemento(campoImagem).sendKeys(caminhoImagem);
        return this;
    }

    public CadastrarProdutosPage clicarCadastrar() {
        driver.findElement(botaoCadastrar).click();
        return this;
    }

    public CadastrarProdutosPage validarPaginaCadastro() {
        String titulo = espera.aguardarElemento(tituloProdutos).getText();
        Assertions.assertEquals("Cadastro de Produtos", titulo);
        CapturarImagem.capturarImagem(driver, "validar-pagina-cadastro");
        return this;
    }


}
