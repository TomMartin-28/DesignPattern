package characters;

import abilities.Ability;
import abilities.SuperBowser;

public class Bowser extends Character{
    public Bowser() {
        super("Bowser", 35, 10, new SuperBowser());
    }
}
