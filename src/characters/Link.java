package characters;

import abilities.Ability;
import abilities.SuperLink;
import strategie.celebrationVictoire.Modestie;

public class Link extends Character{
    public Link() {
        super("Link", 20, 6, new SuperLink());
        this.celebrationVictoire = new Modestie();
    }
}
