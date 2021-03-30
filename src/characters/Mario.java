package characters;

import abilities.SuperMario;

public class Mario extends Character{
    public Mario(){
        super("Mario", 30, 7, new SuperMario());
    }
}
