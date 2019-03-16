package learnData;

/**
 * 不可变对象
 */
public class ImmutableValue {

    private int value;

    public ImmutableValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public ImmutableValue addValue(int value) {
        return new ImmutableValue(this.value + value);
    }
}
