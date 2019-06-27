package learn_java_design.strategy_design;

public class Knight extends Character {
    @Override
    void fight() {
        weaponBehavior.useWrapon();
    }
}
