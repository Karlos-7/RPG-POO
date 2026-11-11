//mapa

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
            Reidemonio::new);

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
