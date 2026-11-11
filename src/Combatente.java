//combatente

public interface Combatente {
    String getNome();
    int getVida();
    int getVidaMaxima();
    int getAtaque();
    int getDefesa();
    int receberDano(int dano);
    boolean estaVivo();
}
