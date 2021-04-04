package characters;

import abilities.Ability;
import abilities.SuperBowser;
import strategie.celebrationVictoire.Arrogance;

public class Bowser extends Character{
    public Bowser() {
        super("Bowser", 35, 10, new SuperBowser());
        this.celebrationVictoire = new Arrogance();
    }
    
    
}
