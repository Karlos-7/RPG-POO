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



