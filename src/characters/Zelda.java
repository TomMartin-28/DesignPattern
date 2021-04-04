package characters;

import abilities.Ability;
import abilities.SuperZelda;
import strategie.celebrationVictoire.NePasCelebrer;

public class Zelda extends Character{
    public Zelda() {
        super("Zelda", 23, 10, new SuperZelda());
        this.celebrationVictoire = new NePasCelebrer();
    }
}
