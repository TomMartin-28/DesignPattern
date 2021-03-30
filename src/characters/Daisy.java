package characters;

import abilities.Ability;
import abilities.SuperDaisy;

public class Daisy extends Character{
    public Daisy() {
        super("Daisy", 23, 5, new SuperDaisy());
    }
}
