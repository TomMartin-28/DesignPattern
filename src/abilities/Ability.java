package abilities;

import characters.Character;

public abstract class Ability extends Character {
    String ability_name;
    public Ability(String name, int pv, int atk, String ability_name) {
        super(name, pv, atk);
        this.ability_name = ability_name;
    }

    public String getAbility_name() {
        return ability_name;
    }
}
