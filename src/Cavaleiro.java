    // cavaleiro

    public class Cavaleiro extends Inimigo {
        public Cavaleiro() {
            super("Cavaleiro", 150, 18, 14, 120); // vida, ataque, defesa, xp
        }

        @Override
        public int atacar() {
            System.out.println(getNome() + " golpeia com sua espada sombria!");
            return getAtaque();
        }
    }
