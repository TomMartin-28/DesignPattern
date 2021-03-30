package characters;

import abilities.Ability;
import abilities.SuperPeach;

public class Peach extends Character{
    public Peach() {
        super("Peach", 23, 6, new SuperPeach());
    }
}
