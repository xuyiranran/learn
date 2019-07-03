package tmp;

import com.google.gson.Gson;
import sun.jvm.hotspot.utilities.BitMap;

import java.util.BitSet;
import java.util.Objects;

public class BloomFilter {


    private int capacity;
    private int expect;
    private BitSet bitSet;

    public BloomFilter(int expect) {
        this.expect = expect;
        this.capacity = expect * 2;
        bitSet = new BitSet(capacity);
    }

    public void add(String string) {
        bitSet.set(hash1(string));
        bitSet.set(hash2(string));
    }


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
