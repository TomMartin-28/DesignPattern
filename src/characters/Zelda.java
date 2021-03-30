package characters;

import abilities.Ability;
import abilities.SuperZelda;

public class Zelda extends Character{
    public Zelda() {
        super("Zelda", 23, 10, new SuperZelda());
    }
}
