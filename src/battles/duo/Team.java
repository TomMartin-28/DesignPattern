package battles.duo;

import characters.Character;

public class Team {
    Character c1, c2;
    public Team(Character c1, Character c2){
        this.c1 = c1;
        this.c2 = c2;
    }

    public Character getC1() {
        return c1;
    }

    public Character getC2() {
        return c2;
    }

    @Override
    public String toString() {
        return c1.getName()+" et "+c2.getName();
    }
}
