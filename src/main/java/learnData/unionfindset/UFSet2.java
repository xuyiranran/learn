package learnData.unionfindset;

import java.util.Random;

public class UFSet2 implements UFSet {

    private int[] data;

    public UFSet2(int size) {
        data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }
    }

    @Override
    public void union(int a, int b) {

        int aset = findSet(a);
        int bset = findSet(b);
        if (aset == bset) return;
        data[a] = bset;

    }

    @Override
    public boolean isConnected(int a, int b) {
        return findSet(a) == findSet(b);
    }

    private int findSet(int element) {
        while (element != data[element]) {
            element = data[element];
        }
        return data[element];
    }


    public static void main(String[] args) {


        int randomint = 1000000;
        UFSet ufSet = new UFSet2(randomint);
        Random random = new Random(randomint);
        long start = System.currentTimeMillis();
        for (int i = 0; i < randomint; i++) {
            ufSet.union(random.nextInt(randomint), random.nextInt(randomint));
            ufSet.isConnected(random.nextInt(randomint), random.nextInt(randomint));
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
