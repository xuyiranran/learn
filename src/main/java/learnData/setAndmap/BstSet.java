package learnData.setAndmap;

import learnData.tree.bst.BST;

/**
 * 基于二分搜索树实现的集合
 * 1、添加 O(log n)
 * 2、删除 O(log n)
 * 3、contains O(log n)
 * 时间复杂度都是O(log n)性能较好
 *
 * @param <E>
 */
public class BstSet<E extends Comparable<E>> implements Set<E> {

    //使用二分搜索树实现集合
    private BST<E> bst;

    public BstSet() {
        bst = new BST<>();
    }

    @Override
    public int size() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    public static void main(String[] args) {

        Set<String> bstset = new BstSet<>();
        bstset.add("hello");
        bstset.add("hello");
        bstset.add("hello");
        bstset.add("hello");

        bstset.add("world");
        bstset.add("test");
        bstset.remove("test");

        System.out.println(bstset.size());

    }
}
