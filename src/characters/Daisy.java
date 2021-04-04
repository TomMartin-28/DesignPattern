package characters;

import abilities.Ability;
import abilities.SuperDaisy;
import strategie.celebrationVictoire.Arrogance;
import strategie.celebrationVictoire.Modestie;

public class Daisy extends Character{
    public Daisy() {
        super("Daisy", 23, 5, new SuperDaisy());
        this.celebrationVictoire = new Modestie();
    }
}
