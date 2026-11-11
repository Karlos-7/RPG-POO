// menbro 03
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






   
   
