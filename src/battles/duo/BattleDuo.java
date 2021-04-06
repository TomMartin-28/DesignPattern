package battles.duo;

import battles.LogSingleton;
import characters.Character;
import characters.FactoryCharacter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class BattleDuo implements BattleInterfaceDuo{
    Character c1, c2, c3, c4;
    int lap;
    LogSingleton log = LogSingleton.getInstance();

    @Override
    public void intro() {
        System.out.println("Bienvenue sur Fight for nothing!");
        log.addText("Log de la partie en 2 contre 2 ");
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        log.addText(formattedDate);

        boolean choice1 = false, choice2 = false, choice3 = false, choice4 = false;
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
        while(!choice3){
            System.out.println("Joueur 3: Quel personnage souhaitez vous jouer?");
            String str = sc.nextLine();
            if(select(str) != null) {
                this.c3 = select(str);
                choice3 = true;
            }
        }
        while(!choice4){
            System.out.println("Joueur 4: Quel personnage souhaitez vous jouer?");
            String str = sc.nextLine();
            if(select(str) != null) {
                this.c4 = select(str);
                choice4 = true;
            }
        }
    }

    @Override
    public void battle2v2() {
        lap = 1;
        Team first, last, forfeit = null;
        Scanner sc = new Scanner(System.in);
        if (choice() == 0) {
            first = new Team(c1, c2);
            last = new Team(c3, c4);
        } else {
            first = new Team(c3, c4);
            last = new Team(c1, c2);
        }
        while (first.getC1().getPv() > 0 && first.getC2().getPv() > 0 && last.getC1().getPv() > 0 && last.getC2().getPv() > 0) {
            // Joueur 1
            first.c1.notiferObservateurs();
            System.out.println("Que va faire " + first.c1.getName() + "?\n(1)Attaquer\t(2)Esquiver\t(3)Capacité spéciale\t(4)Déclarer forfait");
            String str = sc.next().toLowerCase();
            if (str.compareTo("attack") == 0 || str.compareTo("1") == 0) {
                System.out.println("Quel adversaire va t-il toucher? Joueur 3 ou 4?");
                String cible = sc.next().toLowerCase();
                if(cible.contains("3")){
                    if(!last.c1.isDodge()){
                        attack(first.c1, last.c1);
                        last.c1.notiferObservateurs();
                    }
                    else {
                        System.out.println(last.c1.getName() + " a réussi à esquiver.");
                        last.c1.setDodge(false);
                    }
                }
                else if(cible.contains("4")){
                    if(!last.c2.isDodge()){
                        attack(first.c1, last.c2);
                        last.c2.notiferObservateurs();
                    }
                    else {
                        System.out.println(last.c2.getName() + " a réussi à esquiver.");
                        last.c2.setDodge(false);
                    }
                }
            } else if (str.compareTo("dodge") == 0 || str.compareTo("2") == 0) {
                dodge(first.c1);
            } else if(str.compareTo("capacité spéciale") == 0 || str.compareTo("3") == 0){
                if(!first.getC1().isAbilityUsed()) {
                    System.out.println(first.getC1().getName() + "utilise sa capacité spéciale: " + first.getC1().getAbility().getAbility_name());
                    first.c1 = first.c1.getAbility();
                    first.c1.setAbilityUsed(true);
                }
                else System.out.println("La capacité spéciale de " + first.c1.getName() + " a déjà été utilisée.");
            } else if (str.compareTo("forfeit") == 0 || str.compareTo("4") == 0) {
                sc.close();
                forfeit = first;
                break;
            }

            if(last.c1.getPv() <= 0 | last.c2.getPv() <= 0 | first.c1.getPv() <= 0 | first.c2.getPv() <= 0) break;

            // Joueur 2
            System.out.println("Que va faire " + first.c2.getName() + "?\n(1)Attaquer\t(2)Esquiver\t(3)Capacité spéciale\t(4)Déclarer forfait");
            str = sc.next().toLowerCase();
            if (str.compareTo("attack") == 0 || str.compareTo("1") == 0) {
                System.out.println("Quel adversaire va t-il toucher? Joueur 3 ou 4?");
                String cible = sc.next().toLowerCase();
                if(cible.contains("3")){
                    if(!last.c1.isDodge()){
                        attack(first.c2, last.c1);
                        last.c1.notiferObservateurs();
                    }
                    else {
                        System.out.println(last.c1.getName() + " a réussi à esquiver.");
                        last.c1.setDodge(false);
                    }
                }
                else if(cible.contains("4")){
                    if(!last.c2.isDodge()){
                        attack(first.c2, last.c2);
                        last.c2.notiferObservateurs();
                    }
                    else {
                        System.out.println(last.c2.getName() + " a réussi à esquiver.");
                        last.c2.setDodge(false);
                    }
                }

            } else if (str.compareTo("dodge") == 0 || str.compareTo("2") == 0) {
                dodge(first.c2);
            } else if(str.compareTo("capacité spéciale") == 0 || str.compareTo("3") == 0){
                if(!first.c2.isAbilityUsed()) {
                    System.out.println(first.c2.getName() + "utilise sa capacité spéciale: " + first.c2.getAbility().getAbility_name());
                    first.c2 = first.c2.getAbility();
                    first.c2.setAbilityUsed(true);
                }
                else System.out.println("La capacité spéciale de " + first.c2.getName() + " a déjà été utilisée.");
            } else if (str.compareTo("forfeit") == 0 || str.compareTo("4") == 0) {
                sc.close();
                forfeit = first;
                break;
            }

            if(last.c1.getPv() <= 0 | last.c2.getPv() <= 0 | first.c1.getPv() <= 0 | first.c2.getPv() <= 0) break;

            //Joueur 3
            System.out.println("Que va faire " + last.c1.getName() + "?\n(1)Attaquer\t(2)Esquiver\t(3)Capacité spéciale\t(4)Déclarer forfait");
            str = sc.next().toLowerCase();
            if (str.compareTo("attack") == 0 || str.compareTo("1") == 0) {
                System.out.println("Quel adversaire va t-il toucher? Joueur 1 ou 2?");
                String cible = sc.next().toLowerCase();
                if(cible.contains("1")){
                    if(!first.c1.isDodge()){
                        attack(last.c1, first.c1);
                        first.c1.notiferObservateurs();
                    }
                    else {
                        System.out.println(first.c1.getName() + " a réussi à esquiver.");
                        first.c1.setDodge(false);
                    }
                }
                else if(cible.contains("2")){
                    if(!first.c2.isDodge()){
                        attack(last.c1, first.c2);
                        first.c2.notiferObservateurs();
                    }
                    else {
                        System.out.println(first.c2.getName() + " a réussi à esquiver.");
                        last.c2.setDodge(false);
                    }
                }
            } else if (str.compareTo("dodge") == 0 || str.compareTo("2") == 0) {
                dodge(last.c1);
            } else if(str.compareTo("capacité spéciale") == 0 || str.compareTo("3") == 0){
                if(!last.c1.isAbilityUsed()) {
                    System.out.println(last.c1.getName() + " utilise sa capacité spéciale: " + last.c1.getAbility().getAbility_name());
                    last.c1 = last.c1.getAbility();
                    last.c1.setAbilityUsed(true);
                }
                else System.out.println("La capacité spéciale de " + last.c1.getName() + " a déjà été utilisée.");
            } else if (str.compareTo("forfeit") == 0 || str.compareTo("4") == 0) {
                sc.close();
                forfeit = last;
                break;
            }

            if(last.c1.getPv() <= 0 | last.c2.getPv() <= 0 | first.c1.getPv() <= 0 | first.c2.getPv() <= 0) break;

            //Joueur 4
            System.out.println("Que va faire " + last.c2.getName() + "?\n(1)Attaquer\t(2)Esquiver\t(3)Capacité spéciale\t(4)Déclarer forfait");
            str = sc.next().toLowerCase();
            if (str.compareTo("attack") == 0 || str.compareTo("1") == 0) {
                System.out.println("Quel adversaire va t-il toucher? Joueur 1 ou 2?");
                String cible = sc.next().toLowerCase();
                if(cible.contains("1")){
                    if(!first.c1.isDodge()){
                        attack(c4, c1);
                        first.c1.notiferObservateurs();
                    }
                    else {
                        System.out.println(first.c1.getName() + " a réussi à esquiver.");
                        first.c1.setDodge(false);
                    }
                }
                else if(cible.contains("2")){
                    if(!first.c2.isDodge()){
                        attack(last.c2, first.c2);
                        first.c2.notiferObservateurs();
                    }
                    else {
                        System.out.println(first.c2.getName() + " a réussi à esquiver.");
                        last.c2.setDodge(false);
                    }
                }
            } else if (str.compareTo("dodge") == 0 || str.compareTo("2") == 0) {
                dodge(last.c2);
            } else if(str.compareTo("capacité spéciale") == 0 || str.compareTo("3") == 0){
                if(!last.c2.isAbilityUsed()) {
                    System.out.println(last.c2.getName() + " utilise sa capacité spéciale: " + last.c2.getAbility().getAbility_name());
                    last.c2 = last.c2.getAbility();
                    last.c2.setAbilityUsed(true);
                }
                else System.out.println("La capacité spéciale de " + last.c2.getName() + " a déjà été utilisée.");
            } else if (str.compareTo("forfeit") == 0 || str.compareTo("4") == 0) {
                sc.close();
                forfeit = last;
                break;
            }
            lap++;
        }
        sc.close();
        if(first.c1.getPv() <= 0 || first.c2.getPv() <= 0 || forfeit == first){
            System.out.println("Vainqueur: " + last);
            last.c1.effectuerCelebration();
            last.c2.effectuerCelebration();
            log.addText("\nJoueur 1:" + c1.getName());
            log.addText("\nJoueur 2:" + c2.getName());
            log.addText("\nJoueur 3:" + c3.getName());
            log.addText("\nJoueur 4:" + c4.getName());
            log.addText("\nCombat effectué en "+lap+" tours.\n");
            log.addText("Vainqueur: " + last +"\n\n");
        }
        else if(last.c1.getPv() <= 0 || last.c2.getPv() <= 0 || forfeit == last){
            System.out.println("Vainqueur: " + first);
            first.c1.effectuerCelebration();
            first.c2.effectuerCelebration();
            log.addText("\nJoueur 1:" + c1.getName());
            log.addText("\nJoueur 2:" + c2.getName());
            log.addText("\nJoueur 3:" + c3.getName());
            log.addText("\nJoueur 4:" + c4.getName());
            log.addText("\nCombat effectué en "+lap+" tours.\n");
            log.addText("Vainqueur: " + first +"\n\n");
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
