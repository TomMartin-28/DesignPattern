package battles;

import characters.*;
import characters.Character;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Battle {
    Character c1, c2;
    int lap;
    LogSingleton log = LogSingleton.getInstance();
    public Battle() {
        intro();
        battle();
    }

    public void intro(){
        System.out.println("Bienvenue sur Fight for nothing!");
        log.addText("Log de la partie ");
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        log.addText(formattedDate);
        
        boolean choice1 = false, choice2 = false;
        Scanner sc = new Scanner(System.in);
        while(!choice1){
            System.out.println("Joueur 1: Quel personnage souhaitez vous jouer?");
            String str = sc.nextLine();
            if(select(str) != null) {
                this.c1 = select(str);
                choice1 = true;
            }
        }
        while(!choice2){
            System.out.println("Joueur 2: Quel personnage souhaitez vous jouer?");
            String str = sc.nextLine();
            if(select(str) != null) {
                this.c2 = select(str);
                choice2 = true;
            }
        }
    }

    public void battle() {
        lap = 1;
        Character first, last, forfeit = null;
        Scanner sc = new Scanner(System.in);
        if (choice() == 0) {
            first = c1;
            last = c2;
        } else {
            first = c2;
            last = c1;
        }
        while (first.getPv() > 0 && last.getPv() > 0) {
            System.out.println("Que va faire " + first.getName() + "? Vie restante: "+ first.getPv() +"\n(1)Attaquer\t(2)Esquiver\t(3)Capacité spéciale\t(4)Déclarer forfait");
            String str = sc.next().toLowerCase();
            if (str.compareTo("attack") == 0 || str.compareTo("1") == 0) {
                if(!last.isDodge() && lap != 1){
                    System.out.println(last.getName() + " n'a pas réussi à esquiver.");
                    attack(first, last);
                }
                else {
                    System.out.println(last.getName() + " a réussi à esquiver.");
                    last.setDodge(false);
                }
            } else if (str.compareTo("dodge") == 0 || str.compareTo("2") == 0) {
                dodge(first);
            } else if(str.compareTo("capacité spéciale") == 0 || str.compareTo("3") == 0){
                if(!first.isAbilityUsed()) {
                    System.out.println(first.getName() + "utilise sa capacité spéciale: " + first.getAbility().getAbility_name());
                    first = first.getAbility();
                    first.setAbilityUsed(true);
                }
                else System.out.println("La capacité spéciale de " + first.getName() + " a déjà été utilisée.");
            } else if (str.compareTo("forfeit") == 0 || str.compareTo("4") == 0) {
                sc.close();
                forfeit = first;
                break;
            }
            if(last.getPv() <= 0) break;
            System.out.println("Que va faire " + last.getName() + "? Vie restante: "+ last.getPv() +"\n(1)Attaquer\t(2)Esquiver\t(3)Capacité spéciale\t(4)Déclarer forfait");
            str = sc.next().toLowerCase();
            if (str.compareTo("attack") == 0 || str.compareTo("1") == 0) {
                if(!last.isDodge()){
                    System.out.println(first.getName() + " n'a pas réussi à esquiver.");
                    attack(last, first);
                }
                else {
                    System.out.println(first.getName() + " a réussi à esquiver.");
                    first.setDodge(false);
                }
            } else if (str.compareTo("dodge") == 0 || str.compareTo("2") == 0) {
                dodge(last);
            } else if(str.compareTo("capacité spéciale") == 0 || str.compareTo("3") == 0){
                if(!last.isAbilityUsed()) {
                    System.out.println(last.getName() + " utilise sa capacité spéciale: " + last.getAbility().getAbility_name());
                    last = last.getAbility();
                    last.setAbilityUsed(true);
                }
                else System.out.println("La capacité spéciale de " + last.getName() + " a déjà été utilisée.");
            } else if (str.compareTo("forfeit") == 0 || str.compareTo("4") == 0) {
                sc.close();
                forfeit = last;
                break;
            }
            lap++;
        }
        sc.close();
        if(first.getPv() <= 0 || forfeit == first){
            System.out.println("Vainqueur: " + last.getName());
            last.effectuerCelebration();
            log.addText("\nJoueur 1:" + c1.getName());
            log.addText("\nJoueur 2:" + c2.getName());
            log.addText("\nCombat effectu� en "+lap+" tours.\n");
            log.addText("Vainqueur: " + last.getName()+"\n\n");
        }
        else if(last.getPv() <= 0 || forfeit == last){
            System.out.println("Vainqueur: " + first.getName());
            first.effectuerCelebration();
            log.addText("\nJoueur 1:" + c1.getName());
            log.addText("\nJoueur 2:" + c2.getName());
            log.addText("\nCombat effectu� en "+lap+" tours.\n");
            log.addText("Vainqueur: " + first.getName()+"\n\n");
        }
        System.out.println("Fin de combat, " + lap + " tours");
        log.close();
    }

    private int choice() {
        int rand = (int) (Math.random() * 100) + 1;
        return rand % 2;
    }

    private void attack(Character attaquant, Character attaque) {
        attaque.setPv(attaque.getPv() - attaquant.getAtk());
    }

    private void dodge(Character character) {
        int rand = (int) (Math.random() * 100) + 1;
        if(rand <= 30) character.setDodge(true);
    }

    private Character select(String character){
        FactoryCharacter factory = new FactoryCharacter();
        return factory.getPersonnage(character);
    }
}
