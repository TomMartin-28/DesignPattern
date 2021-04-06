package battles;

import battles.duo.BattleDuo;

public class Adapter implements BattleInterface{
    BattleDuo battleDuo;
    public Adapter(BattleDuo battleDuo){
        this.battleDuo = battleDuo;
        intro();
        battle();
    }
    @Override
    public void intro() {
        battleDuo.intro();
    }

    @Override
    public void battle() {
        battleDuo.battle2v2();
    }
}
