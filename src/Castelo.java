
// castelo

import java.util.List;

public class Castelo extends Local {
    public Castelo() {
        super("Castelo", "Um castelo antigo e em ruínas, lar de inimigos poderosos.", 
            List.of(Orc::new, Troll::new, Cavaleiro::new));
    }
}
