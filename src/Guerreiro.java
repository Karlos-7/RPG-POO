// Membro 2

public class Guerreiro extends Personagem {

    // Guerreiro tanque: muita vida e defesa, ataque mais baixo
    public Guerreiro(String nome) {
        super(nome, "Guerreiro", 140, 12, 20); // vida, ataque, defesa
    }

    private static final int DANO_ESPECIAL = 40;

    @Override
    public int ataqueEspecial() {
        System.out.println(getNome() + " usa GOLPE DE ESCUDO!");
        return DANO_ESPECIAL;
    }
}
