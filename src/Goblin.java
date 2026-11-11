
    // goblin

public class Goblin extends Inimigo {
        public Goblin() {
            super("Goblin", 40, 8, 2, 30); // vida, ataque, defesa, xp
        }

        @Override
        public int atacar() {
            System.out.println(getNome() + " ataca com uma adaga enferrujada!");
            return getAtaque();
        }
}
