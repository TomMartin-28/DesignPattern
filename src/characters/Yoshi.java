package characters;

import abilities.Ability;
import abilities.SuperYoshi;
import strategie.celebrationVictoire.NePasCelebrer;

public class Yoshi extends Character{
    public Yoshi() {
        super("Yoshi", 30, 6, new SuperYoshi());
        this.celebrationVictoire = new NePasCelebrer();
    }
}
