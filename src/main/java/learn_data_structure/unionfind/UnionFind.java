package learn_data_structure.unionfind;

/**
 * 并查集
 * 1、union操作(合并操作)
 * 2、isConnection操作(判断两个元素是否在同一个集合)
 */
public interface UnionFind {

    void union(int a, int b);

    boolean isConnetion(int a, int b);
}
