package characters;

import abilities.Ability;
import abilities.SuperToad;
import strategie.celebrationVictoire.NePasCelebrer;

public class Toad extends Character{
    public Toad() {
        super("Toad", 25, 5, new SuperToad());
        this.celebrationVictoire = new NePasCelebrer();
    }
}
