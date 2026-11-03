public class Mago extends Personagem {

    // Mago: pouca vida e defesa, mas o ataque é alto
    public Mago(String nome) {
        super(nome, "Mago", 80, 18, 4); // vida, ataque, defesa
    }

    private static final int DANO_ESPECIAL = 50;

    @Override
    public int ataqueEspecial() {
        System.out.println(getNome() + " lança um FEITIÇO PODEROSO!");
        return DANO_ESPECIAL;
    }
}
