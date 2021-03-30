package characters;

import abilities.Ability;
import abilities.SuperLink;

public class Link extends Character{
    public Link() {
        super("Link", 20, 6, new SuperLink());
    }
}
