package learn_java_design.strategy_design;

public class KnifeBehavior implements WeaponBehavior {
    @Override
    public void useWrapon() {
        System.out.println("使用匕首...");
    }
}
