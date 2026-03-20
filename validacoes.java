package com.sgp.util;


/**
 * Classe utilitária para validação de atributos de personagens de jogos.
 * Garante que os jogadores não criem nomes inválidos ou alcancem níveis impossíveis.
 * * Padrão: Utility Class (Static Only)
 */
public class ValidacoesRPG {


    // Constantes de Regras do Jogo
    private static final int LVL_MIN = 1;
    private static final int LVL_MAX = 99;
    private static final double CP_MIN = 10.0;
    private static final double CP_MAX = 9999.9;


    private ValidacoesRPG() {
        // Bloqueia a instância para manter o código limpo
    }


    /**
     * Valida o Nickname do jogador.
     * Regra: Entre 3 e 12 caracteres, sem espaços e apenas letras/números.
     */
    public static boolean nickValido(String nick) {
        if (nick == null) return false;
        // Regex: Apenas letras e números, de 3 a 12 caracteres
        return nick.matches("^[a-zA-Z0-9]{3,12}$");
    }


    public static String mensagemErroNick(String nick) {
        if (nick == null || nick.trim().isEmpty()) {
            return "LOG: Nickname não pode ser nulo ou vazio!";
        }
        if (nick.length() < 3 || nick.length() > 12) {
            return "LOG: O Nick deve ter entre 3 e 12 caracteres!";
        }
        if (!nick.matches("^[a-zA-Z0-9]*$")) {
            return "LOG: Caracteres especiais não são permitidos no Nick!";
        }
        return "";
    }


    /**
     * Valida o Level do personagem.
     */
    public static boolean levelValido(int level) {
        return level >= LVL_MIN && level <= LVL_MAX;
    }


    public static String mensagemErroLevel(int level) {
        if (level < LVL_MIN) {
            return "LOG: Level insuficiente! O mínimo é " + LVL_MIN + ".";
        } else if (level > LVL_MAX) {
            return "LOG: Level CAP atingido! O máximo é " + LVL_MAX + ".";
        }
        return "";
    }


    /**
     * Valida o Poder de Combate (Combat Power).
     */
    public static boolean cpValido(double cp) {
        return cp >= CP_MIN && cp <= CP_MAX;
    }


    public static String mensagemErroCP(double cp) {
        if (cp < CP_MIN) {
            return "LOG: Poder de combate muito baixo para entrar na Dungeon!";
        } else if (cp > CP_MAX) {
            return "LOG: Valor de CP excede o limite do servidor (Suspeita de Hack!)";
        }
        return "";
    }
}

