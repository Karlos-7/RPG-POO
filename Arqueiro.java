public class Arqueiro extends Personagem {

    private static final int DANO_FLECHA = 25;
    private static final int QUANTIDADE_FLECHAS = 2;

    // Arqueiro: equilibrado, com bom ataque e vida média
    public Arqueiro(String nome) {
        super(nome, "Arqueiro", 100, 14, 8); // vida, ataque, defesa
    }

    @Override
    public int ataqueEspecial() {
        System.out.println(getNome() + " dispara uma CHUVA DE FLECHAS!");
        int total = 0;
        for (int i = 1; i <= QUANTIDADE_FLECHAS; i++) {
            System.out.println("Flecha " + i + ": " + DANO_FLECHA + " de dano");
            total += DANO_FLECHA;
        }
        return total;
    }
}
