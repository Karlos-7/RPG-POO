// caverna

import java.util.List;

public class Caverna extends Local {
    public Caverna() {
        super("Caverna", "Uma caverna úmida e cheia de ecos, onde criaturas espreitam.", 
            List.of(Lobo::new, Orc::new, Troll::new));
    }
}
