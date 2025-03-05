package br.com.serveRest;

import br.com.serveRest.pages.CadastrarProdutosPage;
import br.com.serveRest.pages.CadastrarUsuarioPage;
import br.com.serveRest.pages.ListarProdutosPage;
import br.com.serveRest.pages.TelaPrincipalPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;

import static br.com.serveRest.util.GerarEmail.gerarEmail;
import static br.com.serveRest.util.GerarNomeProduto.gerarNomeProduto;

public class CadastrarProdutoTest extends BaseTest{
    private CadastrarUsuarioPage cadastrarUsuarioPage;
    private TelaPrincipalPage telaPrincipalPage;
    private CadastrarProdutosPage cadastrarProdutosPage;
    private ListarProdutosPage listarProdutosPage;

    @BeforeEach
    public void iniciarTesteCadastroProduto(){
        cadastrarUsuarioPage = new CadastrarUsuarioPage(driver);
        telaPrincipalPage = new TelaPrincipalPage(driver);
        cadastrarProdutosPage = new CadastrarProdutosPage(driver);
        listarProdutosPage = new ListarProdutosPage(driver);
    }

    @Test
    @Feature("Cadastrar Produto")
    public void deveCadastrarProdutoComSucesso(){
        URL url = getClass().getClassLoader().getResource("imagens/notebook.png");
        File imagemFile = new File(url.getFile());
        String caminhoImagem = imagemFile.getAbsolutePath();
        String nome = "Ana";
        String email = gerarEmail(nome);
        String senha = "123456";
        String nomeProduto = gerarNomeProduto("Notebook da Xuxa");
        String mensagemBoasVindas = "Bem Vindo " + nome;
        String preco = "1000";
        String descricao = "O mais potente de todos.";
        String quantidade = "1";

        cadastrarUsuarioPage
                .clicarBotaoCadastrar()
                .preencherNome(nome)
                .preencherEmail(email)
                .preencherSenha(senha)
                .marcarAdministrador()
                .clicarConcluirCadastro();

        telaPrincipalPage
                .validarMensagemBoasVindas(mensagemBoasVindas)
                .clicarBotaoCadastrarProduto();

        cadastrarProdutosPage
                .validarPaginaCadastro()
                .preencherNome(nomeProduto)
                .preencherPreco(preco)
                .preencherDescricao(descricao)
                .preencherQuantidade(quantidade)
                .enviarImagem(caminhoImagem)
                .clicarCadastrar();

    }

}
