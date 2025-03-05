package br.com.serveRest.util;

import java.util.Random;

public class GerarEmail {
    public static String gerarEmail(String nome) {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(1000);
        return nome.toLowerCase() + numeroAleatorio + "@teste.com";
    }
}
