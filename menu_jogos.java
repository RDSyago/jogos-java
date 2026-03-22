package com.sgp.testes;

import java.util.Scanner;
import com.sgp.modelos.Jogador;
import com.sgp.util.ValidacoesRPG;

public class TesteAcessoMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Conectado ao modelo Jogador (Iniciando como Guerreiro nível 1)
        Jogador jogador = new Jogador(); 
        int opcao;

        do {
            imprimirMenu();
            
            opcao = recebeOp(scanner);

            switch (opcao) {
                case 1:
                    // Conectado ao toString do Jogador
                    System.out.println(jogador.toString());
                    break;
                case 2:
                    alterarNome(jogador, scanner);
                    break;
                case 3:
                    alterarNivel(jogador, scanner);
                    break;
                case 4:
                    // Conectado ao método de status/saudação do Jogador
                    jogador.statusJogador();
                    break;
                case 5:
                    validarEntradaDungeon(scanner);
                    break;
                case 0:
                    System.out.println("Sessão encerrada. XP salvo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void imprimirMenu() {
        System.out.println("\n=== HUB DO AVENTUREIRO ===");
        System.out.println("1. Mostrar ficha do personagem");
        System.out.println("2. Alterar Nickname");
        System.out.println("3. Alterar Nível (Level)");
        System.out.println("4. Ver Status de Batalha");
        System.out.println("5. Validar CP para Dungeon");
        System.out.println("0. Sair do Jogo");
        System.out.print("Escolha uma ação: ");
    }

    public static int recebeOp(Scanner scanner){
        int opcao;
        try {
            opcao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite um número válido!");
            opcao = -1;
        }
        return opcao;
    }

    public static void alterarNome(Jogador jogador, Scanner scanner) {
        System.out.print("Digite o novo Nickname: ");
        String novoNick = scanner.nextLine();
        // Conectado à ValidacoesRPG
        if (ValidacoesRPG.nickValido(novoNick)) {
            jogador.setNomeJogador(novoNick);
            System.out.println("Nickname atualizado com sucesso!");
        } else {
            System.out.println(ValidacoesRPG.mensagemErroNick(novoNick));
        }
    }

    public static void alterarNivel(Jogador jogador, Scanner scanner) {
        System.out.print("Digite o novo nível (LVL): ");
        try {
            int novoLevel = Integer.parseInt(scanner.nextLine());
            // Conectado à ValidacoesRPG
            if (ValidacoesRPG.levelValido(novoLevel)) {
                jogador.setNivelExperiencia(novoLevel);
                System.out.println("Nível alterado com sucesso!");
            } else {
                System.out.println(ValidacoesRPG.mensagemErroLevel(novoLevel));
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite um nível numérico inteiro!");
        }
    }

    public static void validarEntradaDungeon(Jogador jogador, Scanner scanner) {
        System.out.print("Informe o CP atual para validação: ");
        try {
            double cp = Double.parseDouble(scanner.nextLine());
            // Conectado à ValidacoesRPG
            if (ValidacoesRPG.cpValido(cp)) {
                System.out.println("Acesso permitido à Dungeon!");
            } else {
                System.out.println(ValidacoesRPG.mensagemErroCP(cp));
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Valor de CP inválido!");
        }
    }
}