package learn_java_design.strategy_design;

public class StrategyApp {

    public static void main(String[] args) {

        Character character = new Queen();
        character.setWeaponBehavior(new SwordBehavior());
        character.fight();

        character.setWeaponBehavior(new KnifeBehavior());
        character.fight();


    }

}
