package learn_java_design.strategy_design.duck;

public class MachineFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("机器动力飞行。。。");
    }
}
