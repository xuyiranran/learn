package learn_java_design.strategy_design;

public class Queen extends Character{

    @Override
    void fight() {
        weaponBehavior.useWrapon();
    }
}
