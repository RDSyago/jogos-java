package com.sgp.testes;

import com.sgp.modelos.Jogador;

public class Teste { // Definição da classe Teste para RPG

    public static void main(String[] args) {
        // Testando o método com um jogador não inicializado (Null Check)
        Jogador heroiNulo = null;
        imprimirJogador(heroiNulo);

        // Testando o método com um jogador inicializado (Davi, Lvl 20)
        Jogador heroi = new Jogador("Davi", 20, 500, "Mago");
        imprimirJogador(heroi);

        // Testando o construtor com valores padrão (Aventureiro Lvl 1)
        Jogador heroiPadrao = new Jogador();
        System.out.println("\n--- Testando Spawn de Herói Padrão ---");
        imprimirJogador(heroiPadrao);

        // Testando um novo herói customizado
        Jogador heroiElite = new Jogador("Ana", 30, 1500, "Arqueira");
        System.out.println("\n--- Testando Herói de Elite ---");
        imprimirJogador(heroiElite);

        // Acesso ao método de status (antiga saudação)
        heroi.statusJogador();

        // Acessando o atributo através do getter público
        System.out.println("Nick do Herói: " + heroi.getNomeJogador());

        // Modificando o atributo através do setter (Troca de nome/Nickname)
        heroi.setNomeJogador("Joao_Destroyer");
        System.out.println("Novo Nick (via setter): " + heroi.getNomeJogador());

        // Modificando o nível através do setter
        heroi.setNivelExperiencia(35);
        System.out.println("Herói após Upgrade: " + heroi.toString());
    }

    /**
     * Método estático para imprimir informações de um jogador.
     * Agora conectado à lógica de RPG.
     */
    public static void imprimirJogador(Jogador jogador) {
        if (jogador == null) {
            System.out.println("⚠️ Jogador não foi criado (está nulo)!");
            return;
        }
        System.out.println(jogador);
        jogador.statusJogador();
    }
}