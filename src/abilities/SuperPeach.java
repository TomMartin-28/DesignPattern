package abilities;

import strategie.celebrationVictoire.NePasCelebrer;

public class SuperPeach extends Ability{
    public SuperPeach() {
        super("Peach", 20, 8, "Cat Peach");
        this.setCelebrationVictoire(new NePasCelebrer());
    }
}
