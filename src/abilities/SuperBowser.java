package abilities;

import strategie.celebrationVictoire.Arrogance;

public class SuperBowser extends Ability{
    public SuperBowser() {
        super("Bowser", 22, 13, "Carapace Piquante");
        this.setCelebrationVictoire(new Arrogance());
    }
}
