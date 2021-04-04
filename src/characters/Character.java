package characters;

import abilities.Ability;
import strategie.celebrationVictoire.CelebrationVictoire;

public abstract class Character {
    String name;
    String type;
    int pv;
    int atk;
    Ability ability;
    boolean abilityUsed;
    boolean dodge;
    CelebrationVictoire celebrationVictoire;


    public Character(String name, int pv, int atk, Ability ability) {
        this(name, pv, atk);
        this.ability = ability;
    }

    public Character(String name, int pv, int atk){
        this.name = name;
        this.pv = pv;
        this.atk = atk;
        this.type = setType();
    }
    
    public void effectuerCelebration() {
    	celebrationVictoire.celebrer();
    }

    public String getName() {
        return name;
    }

    public int getAtk() {
        return atk;
    }

    public int getPv() {
        return pv;
    }

    public String getType() {
        return type;
    }

    public Ability getAbility() {
        return ability;
    }

    public boolean isAbilityUsed() {
        return abilityUsed;
    }

    public boolean isDodge() {
        return dodge;
    }

    public void setAbilityUsed(boolean abilityUsed) {
        this.abilityUsed = abilityUsed;
    }

    public void setDodge(boolean dodge) {
        this.dodge = dodge;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    @Override
    public String toString() {
        return type + "{" +
                "name='" + name + '\'' +
                ", pv=" + pv +
                ", atk=" + atk +
                '}';
    }

    private String setType() {
        String type = this.getClass().getName();
        String res = null;
        for (int i = 0; i < type.length(); i++) {
            if (type.charAt(i) == '.')
                res = type.substring(i + 1);
        }
        return res;
    }
}
