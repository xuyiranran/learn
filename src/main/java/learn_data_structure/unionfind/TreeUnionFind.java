package learn_data_structure.unionfind;

/**
 * 基于树来实现
 * <p>
 * 这个树的特殊之处在于是由孩子节点指向父亲节点的.
 */
public class TreeUnionFind implements UnionFind {


    private int[] parent;

    public TreeUnionFind(int capacity) {
        parent = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            parent[i] = i;
        }
    }

    @Override
    public void union(int first, int second) {

        //首先找到要比对数据的集合
        int aset = findSet(first);
        int bset = findSet(second);

        //如果两个集合是相同的就不用操,作直接返回.
        if (aset == bset) return;
        parent[first] = bset;


    }

    @Override
    public boolean isConnetion(int a, int b) {
        return findSet(a) == findSet(b);
    }

    private int findSet(int value) {
        while (value != parent[value]) {
            value = parent[value];
        }
        return parent[value];
    }

    public static void main(String[] args) {

        UnionFind unionFind = new TreeUnionFind(10);
        System.out.println(unionFind.isConnetion(1, 3));
        unionFind.union(1, 3);
        unionFind.union(3, 5);
        System.out.println(unionFind.isConnetion(1, 5));
        unionFind.union(5, 9);
        System.out.println(unionFind.isConnetion(1, 9));

    }
}
