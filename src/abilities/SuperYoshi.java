package abilities;

import strategie.celebrationVictoire.NePasCelebrer;

public class SuperYoshi extends Ability{
    public SuperYoshi() {
        super("Yoshi", 27, 7, "Oeuf piégé");
        this.setCelebrationVictoire(new NePasCelebrer());
    }
}
