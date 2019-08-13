package learn_java_design.strategy_design.duck;

public class WingFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("翅膀挥动飞行。。。");
    }
}
