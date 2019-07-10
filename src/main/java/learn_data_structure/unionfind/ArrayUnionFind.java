package learn_data_structure.unionfind;

/**
 * 直接基于数组实现并查集
 * find复杂度为O(1)
 * union复杂度为O(n)
 */
public class ArrayUnionFind implements UnionFind {

    //使用数组存放所有元素
    private int[] data;

    public ArrayUnionFind(int capacity) {
        data = new int[capacity];
        //初始化让所有元素都处于独立集合
        //0->0;1->1;2->2;...
        for (int i = 0; i < capacity; i++) {
            data[i] = i;
        }
    }

    @Override
    public void union(int a, int b) {
        int aset = findSet(a);
        int bset = findSet(b);
        //如果a,b两个元素所处集合本来就相等,那么久直接返回
        if (aset == bset) return;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == aset) {
                data[i] = bset;
            }
        }
    }

    @Override
    public boolean isConnetion(int a, int b) {
        return data[a] == data[b];
    }

    //返回元素所对应的的集合
    private int findSet(int value) {
        return data[value];

    }
}
