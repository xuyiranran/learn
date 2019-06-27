package learn_java_design.strategy_design.duck;

/**
 * 鸭子抽象类(机器鸭、木头鸭、普通鸭)
 * 飞行行为和游泳行为不一样
 */
public abstract class Duck {

    FlyBehavior flyBehavior;
    SwimBehavior swimBehavior;

    public void setSwimBehavior(SwimBehavior swimBehavior) {
        this.swimBehavior = swimBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    abstract void fly();

    abstract void swim();

}
