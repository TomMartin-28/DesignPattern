package abilities;

import strategie.celebrationVictoire.Modestie;

public class SuperDaisy extends Ability{
    public SuperDaisy() {
        super("Daisy", 30, 4, "Puissance Crépusculaire");
        setCelebrationVictoire(new Modestie());
    }
}
