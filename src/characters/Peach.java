package characters;

import abilities.Ability;
import abilities.SuperPeach;
import strategie.celebrationVictoire.Modestie;
import strategie.celebrationVictoire.NePasCelebrer;

public class Peach extends Character{
    public Peach() {
        super("Peach", 23, 6, new SuperPeach());
        this.celebrationVictoire = new NePasCelebrer();
    }
}
