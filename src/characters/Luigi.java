package characters;

import abilities.SuperLuigi;
import strategie.celebrationVictoire.Modestie;

public class Luigi extends Character{
    public Luigi() {
        super("Luigi", 25, 9, new SuperLuigi());
        this.celebrationVictoire = new Modestie();
    }
}
