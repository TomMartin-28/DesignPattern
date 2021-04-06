package abilities;

import strategie.celebrationVictoire.NePasCelebrer;

public class SuperToad extends Ability{
    public SuperToad() {
        super("Toad", 27, 5, "Captain Toad");
        this.setCelebrationVictoire(new NePasCelebrer());
    }
}
