
    // lobo

public class Lobo extends Inimigo {
        public Lobo() {
            super("Lobo", 50, 10, 3, 40); // vida, ataque, defesa, xp
        }

        @Override
        public int atacar() {
            System.out.println(getNome() + " avança e morde com fúria!");
            return getAtaque();
        }
    }
