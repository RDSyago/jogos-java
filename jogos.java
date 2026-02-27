package com.sgp.modelos;  // Declaração do pacote

public class Jogador {
    
    private String nomeJogador;      // Nome do jogador
    private int nivelExperiencia;    // Nível de experiência (XP level)
    private int pontuacao;           // Pontuação total do jogador
    private String classeJogador;    // Classe do jogador (Guerreiro, Mago, Arqueiro, etc)

    // Quem recebe todos os dados do jogador
    public Jogador(String nomeJogador, int nivelExperiencia, int pontuacao, String classeJogador) {
        this.nomeJogador = nomeJogador;
        this.nivelExperiencia = nivelExperiencia;
        this.pontuacao = pontuacao;
        this.classeJogador = classeJogador;
    }

    // Inicializa um novo jogador: nome="Aventureiro", nível=1, pontuação=0, classe="Guerreiro"
    public Jogador() {
        this.nomeJogador = "Aventureiro";
        this.nivelExperiencia = 1;
        this.pontuacao = 0;
        this.classeJogador = "Guerreiro";
    }

    // Método que exibe o status do jogador
    public void statusJogador() {
        System.out.println("⚔️ " + nomeJogador + " | Nível: " + nivelExperiencia + " | Pontos: " + pontuacao + " | Classe: " + classeJogador);
    }

    // Métodos para aumentar pontuação e experiência
    public void ganharPontos(int pontos) {
        this.pontuacao += pontos;
        System.out.println(nomeJogador + " ganhou " + pontos + " pontos! Total: " + this.pontuacao);
    }

    public void subirNivel() {
        this.nivelExperiencia++;
        System.out.println(nomeJogador + " subiu para o nível " + this.nivelExperiencia + "!");
    }

    // Métodos Getters e Setters para acesso controlado aos atributos privados
    
    public String getNomeJogador() {
        return nomeJogador;
    }

    public int getNivelExperiencia() {
        return nivelExperiencia;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public String getClasseJogador() {
        return classeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public void setNivelExperiencia(int nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public void setClasseJogador(String classeJogador) {
        this.classeJogador = classeJogador;
    }

    @Override
    public String toString() {
        return "Jogador [nome=" + nomeJogador + ", nível=" + nivelExperiencia + ", pontuação=" + pontuacao + ", classe=" + classeJogador + "]";
    }
}