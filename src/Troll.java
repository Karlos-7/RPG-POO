    // troll

    public class Troll extends Inimigo {
        public Troll() {
            super("Troll", 120, 16, 8, 90); // vida, ataque, defesa, xp
        }

        @Override
        public int atacar() {
            System.out.println(getNome() + " esmaga você com sua clava gigante!");
            return getAtaque();
        }
    }
