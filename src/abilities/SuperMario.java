package abilities;

import characters.Character;
import strategie.celebrationVictoire.Modestie;

public class SuperMario extends Ability{
    public SuperMario() {
        super("Mario", 25, 9, "Fleur de feu");
        this.setCelebrationVictoire(new Modestie());
    }
}
