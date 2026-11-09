// Membro 4


import java.util.Scanner;
import java.util.Random;

public class Batalha {

    private static final Random random = new Random();

    public static String iniciar(Personagem jogador, Inimigo inimigo, Scanner scanner) {

        System.out.println("\n===== INÍCIO DA BATALHA =====");
        System.out.println(jogador.getNome() + " VS " + inimigo.getNome());

        while (jogador.estaVivo() && inimigo.estaVivo()) {

            jogador.exibirStatus();
            inimigo.exibirStatus();

            System.out.println("\n===== BATALHA =====");
            System.out.println("1 - Atacar");
            System.out.println("2 - Ataque especial");
            System.out.println("3 - Usar poção");
            System.out.println("4 - Fugir");

            System.out.print("Escolha uma ação: ");
            int opcao = scanner.nextInt();

            boolean turnoValido = true;

            switch (opcao) {

                case 1: {
                    int dano = jogador.getAtaque() + random.nextInt(6);

                    System.out.println("\nVocê atacou!");

                    int danoRecebido = inimigo.receberDano(dano);

                    System.out.println("Dano causado: " + danoRecebido);
                    break;
                }

                case 2: {
                    if (jogador.podeUsarEspecial()) {

                        int dano = jogador.usarEspecial();
                        int danoRecebido = inimigo.receberDano(dano);

                        System.out.println("Dano especial: " + danoRecebido);

                    } else {
                        System.out.println("Mana insuficiente!");
                        turnoValido = false;
                    }
                    break;
                }

                case 3: {
                    turnoValido = jogador.usarPocao();
                    break;
                }

                case 4: {
                    if (random.nextInt(100) < 50) {
                        System.out.println("\nVocê conseguiu fugir!");
                        return "FUGA";
                    } else {
                        System.out.println("\nVocê não conseguiu fugir!");
                    }
                    break;
                }

                default:
                    System.out.println("Opção inválida!");
                    turnoValido = false;
                    break;
            }

            if (!turnoValido) {
                continue;
            }

            jogador.regenerarMana();

            if (inimigo.estaVivo()) {

                System.out.println("\n===== TURNO DO INIMIGO =====");

                int dano = inimigo.atacar() + random.nextInt(6);

                int danoRecebido = jogador.receberDano(dano);

                System.out.println("Você recebeu " + danoRecebido + " de dano!");
            }
        }

        if (jogador.estaVivo()) {

            System.out.println("\nVocê derrotou " + inimigo.getNome() + "!");

            jogador.ganharXp(inimigo.getXpRecompensa());

            return "VITORIA";

        } else {

            System.out.println("\nVocê foi derrotado!");

            return "DERROTA";
        }
    }
}
