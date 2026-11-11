// floresta

import java.util.List;

public class Floresta extends Local {
    public Floresta() {
        super("Floresta Sombria", "Uma floresta densa e escura, cheia de perigos.", 
            List.of(Goblin::new, Lobo::new));
    }
}
