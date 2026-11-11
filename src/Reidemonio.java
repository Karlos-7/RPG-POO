 //reiDemonio

    public class Reidemonio extends Inimigo {

        public Reidemonio() {
            super("Rei Demônio", 400, 32, 20, 500); // vida, ataque, defesa, xp
        }

        @Override
        public int atacar() {
            // abaixo de 50% de vida entra em furia e causa mais dano
            if (getVida() < getVidaMaxima() / 2) {
                System.out.println(getNome() + " entra em fúria e ataca com força total!");
                return getAtaque() + 10; // +10 de dano
            }
            System.out.println(getNome() + " ataca com sua espada demoníaca!");
            return getAtaque();
        }
    }

    
