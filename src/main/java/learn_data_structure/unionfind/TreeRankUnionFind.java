package learn_data_structure.unionfind;

/**
 * 基于rank优化的(即基于树高度作为参考来优化)
 */
public class TreeRankUnionFind implements UnionFind {

    private int[] data;
    private int[] rank;

    public TreeRankUnionFind(int capacity) {
        data = new int[capacity];
        rank = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            data[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public void union(int first, int second) {

        int firstSet = findSet(first);
        int secondSet = findSet(second);
        if (firstSet == secondSet) return;
        if (rank[firstSet] < rank[secondSet]) {
            data[first] = secondSet;
        } else if (rank[firstSet] > rank[secondSet]) {
            data[second] = firstSet;
        } else {
            data[first] = secondSet;
            rank[secondSet]++;
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

        UnionFind unionFind = new TreeRankUnionFind(10);
        System.out.println(unionFind.isConnetion(1, 3));
        unionFind.union(1, 3);
        unionFind.union(3, 5);
        System.out.println(unionFind.isConnetion(1, 5));
        unionFind.union(5, 9);
        System.out.println(unionFind.isConnetion(1, 9));

    }
}
