 // dragao 

    public class Dragao extends Inimigo {

        private static final int BONUS_FOGO = 10;

        // em turnos alterados, solta o sopro de fogo
        private boolean proximoSopro = false;

        public Dragao() {
            super("Dragão", 250, 25, 15, 250); // vida, ataque, defesa, xp
        }

        @Override
        public int atacar() {
            proximoSopro = !proximoSopro;
            if (proximoSopro) {
                System.out.println(getNome() + " cospe um SOPRO DE FOGO!");
                return getAtaque() + BONUS_FOGO;
            } 
            System.out.println(getNome() + " ataca com as garras!");
            return getAtaque();
        }
    }
