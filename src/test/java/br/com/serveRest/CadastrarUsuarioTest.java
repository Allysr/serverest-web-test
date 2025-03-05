package br.com.serveRest;

import br.com.serveRest.pages.CadastrarUsuarioPage;
import br.com.serveRest.pages.TelaPrincipalPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static br.com.serveRest.util.GerarEmail.gerarEmail;

public class CadastrarUsuarioTest extends BaseTest{
    private CadastrarUsuarioPage cadastrarUsuarioPage;
    private TelaPrincipalPage telaPrincipalPage;

    @BeforeEach
    public void iniciarTesteCadastro(){
        cadastrarUsuarioPage = new CadastrarUsuarioPage(driver);
        telaPrincipalPage = new TelaPrincipalPage(driver);
    }

    @Test
    @Feature("Cadastrar Usuário")
    public void deveCadastrarUsuarioComSucesso() {
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
                    .validarMensagemBoasVindas(mensagemBoasVindas);
        }
}
