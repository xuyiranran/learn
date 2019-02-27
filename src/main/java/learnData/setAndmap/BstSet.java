package learnData.setAndmap;

import learnData.tree.bst.BST;

public class BstSet<E extends Comparable<E>> implements Set<E> {

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
