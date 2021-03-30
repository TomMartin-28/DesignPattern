package characters;

import abilities.Ability;
import abilities.SuperToad;

public class Toad extends Character{
    public Toad() {
        super("Toad", 25, 5, new SuperToad());
    }
}
