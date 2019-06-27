package learn_java_design.strategy_design.duck;

public class WingSwimBehavior implements SwimBehavior {
    @Override
    public void swim() {

        System.out.println("翅膀挥动游泳。。。");
    }
}
