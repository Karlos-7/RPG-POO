
    // orc

    public class Orc extends Inimigo {
        public Orc() {
            super("Orc", 80, 14, 6, 60); // vida, ataque, defesa, xp
        }

        @Override
        public int atacar() {
            System.out.println(getNome() + " desce o machado com força bruta!");
            return getAtaque();
        }
    }
