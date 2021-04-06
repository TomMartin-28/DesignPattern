package characters;

import abilities.Ability;
import observateur.AffichagePV;
import observateur.Observateur;
import observateur.Sujet;
import strategie.celebrationVictoire.CelebrationVictoire;

import java.util.ArrayList;
import java.util.List;

public abstract class Character implements Sujet {
    List<Observateur> observateurs = new ArrayList();
    String name;
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
        new AffichagePV(this);
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

    public void setCelebrationVictoire(CelebrationVictoire celebrationVictoire) {
        this.celebrationVictoire = celebrationVictoire;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", pv=" + pv +
                ", atk=" + atk +
                '}';
    }

    public void enregistrerObservateur(Observateur o) {	//++
        observateurs.add(o);
    }

    public void supprimerObservateur(Observateur o) {	//++
        observateurs.remove(o);
    }

    public void notiferObservateurs() {
        for (Observateur obs: observateurs) {
            obs.actualiser(name,pv);
        }
    }
}
