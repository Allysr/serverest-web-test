package br.com.serveRest;

import br.com.serveRest.pages.CadastrarUsuarioPage;
import br.com.serveRest.pages.LoginPage;
import br.com.serveRest.pages.TelaPrincipalPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static br.com.serveRest.util.GerarEmail.gerarEmail;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private CadastrarUsuarioPage cadastrarUsuarioPage;
    private TelaPrincipalPage telaPrincipalPage;

    @BeforeEach
    public void iniciarTesteLogin(){
        loginPage = new LoginPage(driver);
        telaPrincipalPage = new TelaPrincipalPage(driver);
        cadastrarUsuarioPage = new CadastrarUsuarioPage(driver);
    }

    @Test
    @Feature("Login")
    public void deveRealizarLoginComSucesso(){
        String nome = "Ana";
        String email = gerarEmail(nome);
        String senha = "123456";
        String mensagemBoasVindas = "Bem Vindo " + nome;

        cadastrarUsuarioPage
                .clicarBotaoCadastrar()
                .preencherNome(nome)
                .preencherEmail(email)
                .preencherSenha(senha)
                .marcarAdministrador()
                .clicarConcluirCadastro();

        telaPrincipalPage
                .clicarBotaoDeslogar();

        loginPage
                .validarTituloPagina("Login")
                .preencherEmail(email)
                .preencherSenha(senha)
                .clicarLogin();

    }

}
