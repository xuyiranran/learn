package learn_java_design.strategy_design;

public abstract class Character {


    WeaponBehavior weaponBehavior;

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    abstract void fight();


}
