package learn_java_design.strategy_design;

public class SwordBehavior implements WeaponBehavior {
    @Override
    public void useWrapon() {
        System.out.println("使用宝剑...");
    }
}
