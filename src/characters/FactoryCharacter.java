package characters;

public class FactoryCharacter {
    public Character getPersonnage(String character) {
        if (character.equalsIgnoreCase("Bowser")) {
            return new Bowser();
        } else if (character.equalsIgnoreCase("Link")) {
            return new Link();
        } else if (character.equalsIgnoreCase("Daisy")) {
            return new Daisy();
        } else if (character.equalsIgnoreCase("Luigi")) {
            return new Luigi();
        } else if (character.equalsIgnoreCase("Mario")) {
            return new Mario();
        } else if (character.equalsIgnoreCase("Peach")) {
            return new Peach();
        } else if (character.equalsIgnoreCase("Toad")) {
            return new Toad();
        } else if (character.equalsIgnoreCase("Yoshi")) {
            return new Yoshi();
        } else if (character.equalsIgnoreCase("Zelda")) {
            return new Zelda();
        } else {
            return null;
        }
    }

}