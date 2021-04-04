package characters;

import abilities.SuperMario;
import strategie.celebrationVictoire.Modestie;

public class Mario extends Character{
    public Mario(){
        super("Mario", 30, 7, new SuperMario());
        this.celebrationVictoire = new Modestie();
    }
}
