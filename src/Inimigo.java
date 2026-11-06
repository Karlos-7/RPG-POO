// Membro 3

public interface Combatente {
    String getNome();
    int getVida();
    int getVidaMaxima();
    int getAtaque();
    int getDefesa();
    int receberDano(int dano);
    boolean estaVivo();
}

// inimigo

public abstract class Inimigo implements Combatente {

    private final String nome;
    private int vida;
    private final int vidaMaxima;
    private final int ataque;
    private final int defesa;
    private final int xpRecompensa;

    protected Inimigo(String nome, int vida, int ataque, int defesa, int xpRecompensa) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.xpRecompensa = xpRecompensa;
    }

   // cada inimigo pode descrever o proprio ataque , devolve o dano causado
    public int atacar() {
        System.out.println(nome + " ataca!");
        return ataque;
   } 

   // mesma formula de dano do personagem
   @Override
    public int receberDano(int dano) {
        int efetivo = Math.max(1, dano - defesa / 2);
        vida = Math.max(0, vida - efetivo);
        return efetivo;
    }

    @Override
    public boolean estaVivo() {
        return vida > 0;
    }

    public void exibirStatus() {
        System.out.println(nome + " HP: " + vida + "/" + vidaMaxima);
    }

    @Override public String getNome()   {return nome;}
    @Override public int getVida()      {return vida;}
    @Override public int getVidaMaxima() {return vidaMaxima;}
    @Override public int getAtaque()    {return ataque;}
    @Override public int getDefesa()    {return defesa;}
    public int getXpRecompensa()         {return xpRecompensa;}

}

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

    //reiDemonio

    public class ReiDemonio extends Inimigo {

        public ReiDemonio() {
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

    // local

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Local {

        private static final Random RANDOM = new Random();

        private final String nome;
        private final String descricao;
        // supplier para criar inimigos dinamicamente
        private final List<Supplier<Inimigo>> inimigos;

        public Local(String nome, String descricao, List<Supplier<Inimigo>> inimigos) {
            this.nome = nome;
            this.descricao = descricao;
            this.inimigos = inimigos;
        }

        public Inimigo sortearInimigo() {
            return inimigos.get(RANDOM.nextInt(inimigos.size())).get();
        }

        public String getNome() { return nome;}
        public String getDescricao() { return descricao;}

}

// floresta

import java.util.List;

public class Floresta extends Local {
    public Floresta() {
        super("Floresta Sombria", "Uma floresta densa e escura, cheia de perigos.", 
            List.of(Goblin::new, Lobo::new));
    }
}

// caverna

import java.util.List;

public class Caverna extends Local {
    public Caverna() {
        super("Caverna", "Uma caverna úmida e cheia de ecos, onde criaturas espreitam.", 
            List.of(Lobo::new, Orc::new, Troll::new));
    }
}

// castelo

import java.util.List;

public class Castelo extends Local {
    public Castelo() {
        super("Castelo", "Um castelo antigo e em ruínas, lar de inimigos poderosos.", 
            List.of(Orc::new, Troll::new, Cavaleiro::new));
    }
}

import java.util.List;
import java.util.function.Supplier;

public class Mapa {

    public static final int VITORIAS_PARA_CHEFE = 6;

    private final List<Local> locais = List.of(
        new Floresta(),
        new Caverna(),
        new Castelo());

        //chefes em ordem: dragão, rei demônio por ultimo
        private final List<Supplier<Inimigo>> chefes = List.of(
            Dragao::new,
            ReiDemonio::new);

        private int vitorias = 0;
        private int chefesDerrotados = 0;

        public void exibirMapa() {
            System.out.println("===========================");
            System.out.println("           MAPA");
            System.out.println("===========================");
            for (int i = 0; i < locais.size(); i++) {
                Local local = locais.get(i);
                System.out.println((i + 1) + ". " + local.getNome() + " - " + local.getDescricao());
            }
            if (chefeLiberado() && !jogoConcluido()) {
                System.out.println((locais.size() + 1) + " - Covil do Chefe (LIBERADO!)");
            }
            else if (!jogoConcluido()) {
                System.out.println("Chefe final: vença mais " + (VITORIAS_PARA_CHEFE - vitorias) + " batalha(s).");
            }
            System.out.println("===========================");
        }

        // opcao começa em 1; retorna o local ou null se inválido
        public Local selecionarLocal(int opcao) {
            if (opcao < 1 || opcao > locais.size()) {
                return null;
            }
            return locais.get(opcao - 1);
        }

        public Inimigo sortearInimigo(Local local) {
            return local.sortearInimigo();
        }

        public void registrarVitoria() {
            vitorias++;
            if (vitorias == VITORIAS_PARA_CHEFE) {
                System.out.println("Uma presença sombria se aproxima... O Covil do Chefe foi liberado!");
            }
        }

        public boolean chefeLiberado() {
            return vitorias >= VITORIAS_PARA_CHEFE;
        }

        public Inimigo proximoChefe() {
            if (!chefeLiberado() || jogoConcluido()) {
                return null; 
                
            }
            return chefes.get(chefesDerrotados).get();   
        }

        public void registrarDerrotaDoChefe() {
            chefesDerrotados++;
        }

        public boolean jogoConcluido() {
            return chefesDerrotados >= chefes.size();
        }

        public int getVitorias() {
            return vitorias;
        }
}
