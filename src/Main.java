import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("         RPG DE BATALHA");
        System.out.println("================================");

        System.out.print("Digite o nome do personagem: ");
        String nome = scanner.nextLine().trim();

        while (nome.isEmpty()) {
            System.out.print("O nome não pode ficar vazio. Digite novamente: ");
            nome = scanner.nextLine().trim();
        }

        Personagem jogador = escolherPersonagem(scanner, nome);
        Mapa mapa = new Mapa();

        while (jogador.estaVivo() && !mapa.jogoConcluido()) {
            jogador.exibirStatus();
            mapa.exibirMapa();

            int opcao = lerInteiro(scanner, "Escolha um local (ou 0 para sair): ");

            if (opcao == 0) {
                break;
            }

            Inimigo inimigo;
            boolean batalhaContraChefe = false;

            if (opcao == 4 && mapa.chefeLiberado()) {
                inimigo = mapa.proximoChefe();
                batalhaContraChefe = true;
            } else {
                Local local = mapa.selecionarLocal(opcao);

                if (local == null) {
                    System.out.println("Opção inválida. Escolha um local disponível.");
                    continue;
                }

                System.out.println("\nVocê entrou em " + local.getNome() + ".");
                System.out.println(local.getDescricao());

                inimigo = mapa.sortearInimigo(local);
            }

            String resultado = Batalha.iniciar(jogador, inimigo, scanner);

            // Batalha lê as ações com nextInt(); esta chamada consome o fim da linha.
            scanner.nextLine();

            if ("VITORIA".equals(resultado)) {
                if (batalhaContraChefe) {
                    mapa.registrarDerrotaDoChefe();
                } else {
                    mapa.registrarVitoria();
                }
            } else if ("DERROTA".equals(resultado)) {
                break;
            }
            // Se o resultado for "FUGA", o jogador volta ao mapa sem registrar vitória.
        }

        if (!jogador.estaVivo()) {
            System.out.println("\nFim de jogo: seu personagem foi derrotado.");
        } else if (mapa.jogoConcluido()) {
            System.out.println("\nParabéns! Você derrotou os chefes e concluiu o jogo!");
        } else {
            System.out.println("\nVocê encerrou a aventura.");
        }

        scanner.close();
    }

    private static Personagem escolherPersonagem(Scanner scanner, String nome) {
        while (true) {
            System.out.println("\nEscolha sua classe:");
            System.out.println("1 - Guerreiro");
            System.out.println("2 - Arqueiro");
            System.out.println("3 - Mago");

            int opcao = lerInteiro(scanner, "Opção: ");

            switch (opcao) {
                case 1:
                    return new Guerreiro(nome);
                case 2:
                    return new Arqueiro(nome);
                case 3:
                    return new Mago(nome);
                default:
                    System.out.println("Opção inválida. Escolha 1, 2 ou 3.");
            }
        }
    }

    private static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro.");
            }
        }
    }
}
