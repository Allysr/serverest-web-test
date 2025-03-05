package br.com.serveRest.util;

import java.util.Random;

public class GerarNomeProduto {
    public static String gerarNomeProduto(String nome) {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(1000);
        return nome.toLowerCase() + numeroAleatorio;
    }
}
