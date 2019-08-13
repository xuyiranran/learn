package learn_data_structure.unionfind;

/**
 * 并查集
 * 1、union操作(合并操作)
 * 2、isConnection操作(判断两个元素是否在同一个集合)
 */
public interface UnionFind {

    /**
     * 合并操作,将first和second两个元素所在的集合划分在同一集合下
     *
     * @param first
     * @param second
     */
    void union(int first, int second);

    /**
     * 判断两个元素是否在同一个集合
     *
     * @param first
     * @param second
     * @return
     */
    boolean isConnetion(int first, int second);
}
