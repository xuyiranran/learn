package learn_java_design.strategy_design.duck;

public class MachineDuck extends Duck {

    @Override
    void fly() {
        flyBehavior.fly();
    }

    @Override
    void swim() {
    }
}
