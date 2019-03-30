package learnData.setAndmap;

import learnData.tree.bst.BST;
import learnData.tree.bst.CommonBST;

/**
 * 基于二叉搜索树实现的映射
 * 整体操作的复杂度平均都能达到O(log n)
 *
 * @param <K> 建议是字符串类型
 * @param <V>
 */
public class CommonBstMap<K extends Comparable<K>, V> implements Map<K, V> {

    private CommonBST<K, V> commonBST;

    public CommonBstMap() {
        commonBST = new CommonBST<>();
    }

    @Override
    public void add(K k, V v) {
        commonBST.add(k, v);
    }

    @Override
    public V remove(K v) {
        return commonBST.remove();
    }

    @Override
    public boolean contains(K k) {
        return commonBST.contains(k);
    }

    @Override
    public V get(K k) {
        return commonBST.get(k);
    }

    @Override
    public void set(K k, V v) {
        commonBST.set(k, v);
    }

    @Override
    public int getSize() {
        return commonBST.getSize();
    }

    @Override
    public boolean isEmpty() {
        return commonBST.isEmpty();
    }
}
