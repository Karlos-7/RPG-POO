// Membro 1

public abstract class Personagem {

    public static final int MANA_INICIAL = 50;
    public static final int CUSTO_ESPECIAL = 20;
    public static final int REGENERACAO_MANA = 10;
    public static final int POCOES_INICIAIS = 3;
    public static final int CURA_POCAO = 30;
    public static final int XP_POR_NIVEL = 100;
    public static final int BONUS_VIDA_NIVEL = 20;
    public static final int BONUS_ATAQUE_NIVEL = 5;

    private final String nome;
    private final String classe;
    private int vida;
    private int vidaMaxima;
    private int mana;
    private int manaMaxima;
    private int ataque;
    private int defesa;
    private int nivel;
    private int xp;
    private int pocoes;


    protected Personagem(String nome, String classe, int vida, int ataque, int defesa) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do personagem não pode ser vazio.");
        }

        this.nome = nome.trim();
        this.classe = classe;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.mana = MANA_INICIAL;
        this.manaMaxima = MANA_INICIAL;
        this.ataque = ataque;
        this.defesa = defesa;
        this.nivel = 1;
        this.xp = 0;
        this.pocoes = POCOES_INICIAIS;
    }


    public abstract int ataqueEspecial();


    public int usarEspecial() {
        if (mana < CUSTO_ESPECIAL) {
            System.out.println("Mana insuficiente!");
            return 0;
        }
        mana -= CUSTO_ESPECIAL;
        return ataqueEspecial();
    }
    public boolean podeUsarEspecial() {
        return mana >= CUSTO_ESPECIAL;
    }

    public int receberDano(int dano) {
        int efetivo = Math.max(1, dano - defesa / 2);
        vida = Math.max(0, vida - efetivo);
        return efetivo;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public boolean usarPocao() {
        if (pocoes <= 0) {
            System.out.println("Você não tem poções!");
            return false;
        }
        if (vida >= vidaMaxima) {
            System.out.println("Sua vida já está cheia!");
            return false;
        }
        pocoes--;
        int curado = Math.min(CURA_POCAO, vidaMaxima - vida);
        vida += curado;
        System.out.println("Você utilizou uma poção!");
        System.out.println("+" + curado + " HP");
        System.out.println("Vida: " + vida + "/" + vidaMaxima);
        return true;
    }

    public void regenerarMana() {
        mana = Math.min(manaMaxima, mana + REGENERACAO_MANA);
    }

    public boolean ganharXp(int quantidade) {
        if (quantidade <= 0) {
            return false;
        }
        xp += quantidade;
        System.out.println("+" + quantidade + " XP");
        boolean subiu = false;
        while (xp >= XP_POR_NIVEL) {
            xp -= XP_POR_NIVEL;
            subirNivel();
            subiu = true;
        }
        return subiu;
    }

    public void subirNivel() {
        nivel++;
        vidaMaxima += BONUS_VIDA_NIVEL;
        vida += BONUS_VIDA_NIVEL;
        ataque += BONUS_ATAQUE_NIVEL;
        System.out.println("================================");
        System.out.println("      VOCÊ SUBIU DE NÍVEL!");
        System.out.println("================================");
        System.out.println("Nível: " + nivel);
        System.out.println("Vida: +" + BONUS_VIDA_NIVEL);
        System.out.println("Ataque: +" + BONUS_ATAQUE_NIVEL);
    }

    public void exibirStatus() {
        System.out.println("================================");
        System.out.println("    STATUS DO PERSONAGEM");
        System.out.println("================================");
        System.out.println("Nome:   " + nome);
        System.out.println("Classe:   " + classe);
        System.out.println("Nível:   " + nivel);
        System.out.println("XP:   " + xp + "/" + XP_POR_NIVEL);
        System.out.println("Vida:   " + vida + "/" + vidaMaxima);
        System.out.println("Mana:   " + mana + "/" + manaMaxima);
        System.out.println("Ataque:   " + ataque);
        System.out.println("Defesa:   " + defesa);
        System.out.println("Poções:   " + pocoes);
        System.out.println("================================");
    }

    public String getNome()  { return nome; }
    public String getClasse()  { return classe; }
    public int getVida()   { return vida; }
    public int getVidaMaxima()   { return vidaMaxima; }
    public int getMana()   { return mana; }
    public int getManaMaxima()   { return manaMaxima; }
    public int getAtaque()   { return ataque; }
    public int getDefesa()   { return defesa; }
    public int getNivel()   { return nivel; }
    public int getXp()   { return xp; }
    public int getPocoes()   { return pocoes; }
    
}