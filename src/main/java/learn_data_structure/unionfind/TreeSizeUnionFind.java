package learn_data_structure.unionfind;

/**
 * 基于size优化(即基于树的节点个数)
 */
public class TreeSizeUnionFind implements UnionFind {

    private int[] data;
    private int[] size;

    public TreeSizeUnionFind(int capacity) {
        data = new int[capacity];
        size = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            data[i] = i;
            size[i] = 1;
        }
    }

    @Override
    public void union(int first, int second) {
        int firstSet = findSet(first);
        int secondSet = findSet(second);
        if (firstSet == secondSet) return;
        if (size[first] < size[second]) {
            data[first] = secondSet;
            size[second] = size[first] + size[second];
        } else {
            data[second] = firstSet;
            size[first] = size[first] + size[second];
        }
    }

    @Override
    public boolean isConnetion(int first, int second) {
        return findSet(first) == findSet(second);
    }

    private int findSet(int value) {
        while (value != data[value]) {
            value = data[value];
        }
        return data[value];
    }

    public static void main(String[] args) {

        UnionFind unionFind = new TreeSizeUnionFind(10);
        System.out.println(unionFind.isConnetion(1, 3));
        unionFind.union(1, 3);
        unionFind.union(3, 5);
        System.out.println(unionFind.isConnetion(1, 5));
        unionFind.union(5, 9);
        System.out.println(unionFind.isConnetion(1, 9));

    }

}
