package abilities;

import strategie.celebrationVictoire.Modestie;

public class SuperLink extends Ability{
    public SuperLink() {
        super("Link", 25, 6, "Majora's Mask");
        this.setCelebrationVictoire(new Modestie());
    }
}
