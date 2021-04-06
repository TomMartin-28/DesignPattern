package abilities;

import strategie.celebrationVictoire.Modestie;

public class SuperLuigi extends Ability{
    public SuperLuigi() {
        super("Luigi", 35, 7, "Le fantôme de Luigi");
        this.setCelebrationVictoire(new Modestie());
    }
}
