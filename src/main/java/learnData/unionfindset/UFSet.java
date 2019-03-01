package learnData.unionfindset;

/**
 * 并查集
 * 1、合并操作(合并两个元素在同一个集合)
 * 2、判断是否连接(是否在同一个集合中)
 */
public interface UFSet {


    /**
     * 合并两个元素
     *
     * @param a
     * @param b
     */
    void union(int a, int b);

    /**
     * 判断两个元素是否在同一个集合
     *
     * @param a
     * @param b
     * @return
     */
    boolean isConnected(int a, int b);

}
