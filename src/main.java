import battles.Adapter;
import battles.Battle;
import battles.BattleInterface;
import battles.duo.BattleDuo;
import characters.Character;
import characters.Luigi;
import characters.Mario;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez-vous jouez en 1 contre 1 (1) ou en 2 contre 2 (2)?");
        while(scanner.hasNext()) {
            String str = scanner.next();
            BattleInterface battle;
            if (str.equalsIgnoreCase("1")){
                battle = new Battle();
                break;
            }
            else if (str.equalsIgnoreCase("2")){
                battle = new Adapter(new BattleDuo());
                break;
            }
            else {
                System.out.println("Réponse erronée, veuillez réessayer");
                System.out.println("Voulez-vous jouez en 1 contre 1 (1) ou en 2 contre 2 (2)?");
            }
        }
        scanner.close();
    }
}