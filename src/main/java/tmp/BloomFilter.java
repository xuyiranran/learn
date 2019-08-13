package tmp;

import java.util.BitSet;
import java.util.Objects;

/**
 * 布隆过滤器简单实现
 */

public class BloomFilter {


    //期望存放的元素
    private int expect;
    //位数组长度
    private int capacity;
    //位数组
    private BitSet bitSet;

    public BloomFilter(int expect) {
        this.capacity = expect * 2;
        this.expect=expect;
        bitSet = new BitSet(capacity);
    }

    //添加元素
    public void add(String string) {
        bitSet.set(hash1(string));
        bitSet.set(hash2(string));
    }


    //判断元素是否存在集合内
    public boolean exist(String string) {
        boolean hash1 = bitSet.get(hash1(string));
        boolean hash2 = bitSet.get(hash1(string));
        return hash1 && hash2;
    }


    private int hash1(String string) {
        return Math.abs(Objects.hashCode(string) % capacity);
    }

    private int hash2(String string) {
        return Math.abs(Objects.hashCode(string + "test") % capacity);
    }

    public static void main(String[] args) {

        BloomFilter bloomFilter = new BloomFilter(100);

        bloomFilter.add("hello");
        bloomFilter.add("Hello");

        System.out.println(bloomFilter.exist("hello"));
        System.out.println(bloomFilter.exist("hello1"));


    }

}
