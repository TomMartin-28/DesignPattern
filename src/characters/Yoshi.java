package characters;

import abilities.Ability;
import abilities.SuperYoshi;

public class Yoshi extends Character{
    public Yoshi() {
        super("Yoshi", 30, 6, new SuperYoshi());
    }
}
