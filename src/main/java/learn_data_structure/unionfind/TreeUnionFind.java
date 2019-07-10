package learn_data_structure.unionfind;

public class TreeUnionFind implements UnionFind {


    private int[] data;

    public TreeUnionFind(int capacity) {
        data = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            data[i] = i;
        }
    }

    @Override
    public void union(int a, int b) {

    }

    @Override
    public boolean isConnetion(int a, int b) {
        return false;
    }

    private int findset(int value){

        return 0;

    }

}
