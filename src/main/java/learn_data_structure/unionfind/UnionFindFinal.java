package learn_data_structure.unionfind;

/**
 * 基于路径压缩来优化
 */
public class UnionFindFinal implements UnionFind {


    private int[] data;//实际存放元素容器
    private int[] rank;//set rank值

    public UnionFindFinal(int capacity) {
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
        if (rank[firstSet] > rank[secondSet]) {
            data[second] = data[first];
        } else if (rank[firstSet] < rank[secondSet]) {
            data[first] = data[second];
        } else {
            data[first] = data[second];
            rank[secondSet]++;
        }
    }

    @Override
    public boolean isConnetion(int first, int second) {
        return findSet(first) == findSet(second);
    }


    public int findSet(int value) {
        while (value != data[value]) {
            //核心算法-往根节点进一层
            value = data[value];
            data[value] = data[data[value]];
        }
        return data[value];
    }

    public static void main(String[] args) {

        UnionFind unionFind = new UnionFindFinal(10);
        System.out.println(unionFind.isConnetion(1, 3));
        unionFind.union(1, 3);
        unionFind.union(3, 5);
        System.out.println(unionFind.isConnetion(1, 5));
        unionFind.union(5, 9);
        System.out.println(unionFind.isConnetion(1, 9));

    }

}
