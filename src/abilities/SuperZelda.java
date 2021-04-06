package abilities;

import strategie.celebrationVictoire.NePasCelebrer;

public class SuperZelda extends Ability{
    public SuperZelda() {
        super("Zelda", 30, 5, "Tri-force");
        this.setCelebrationVictoire(new NePasCelebrer());
    }
}
