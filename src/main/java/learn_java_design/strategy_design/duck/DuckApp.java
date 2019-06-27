package learn_java_design.strategy_design.duck;

public class DuckApp {

    public static void main(String[] args) {

        Duck machineDuck = new MachineDuck();
        machineDuck.setFlyBehavior(new MachineFlyBehavior());

        machineDuck.fly();
        machineDuck.swim();

        Duck simpleDuck = new SimpleDuck();
        simpleDuck.setFlyBehavior(new WingFlyBehavior());
        simpleDuck.setSwimBehavior(new WingSwimBehavior());
        simpleDuck.fly();
        simpleDuck.swim();


    }
}
