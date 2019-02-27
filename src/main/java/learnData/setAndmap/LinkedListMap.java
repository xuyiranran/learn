package learnData.setAndmap;

import learnData.linklist.LinkedList;

public class LinkedListMap<K extends Comparable<K>, V> implements Map<K, V> {


    private LinkedList<K> linkedList;

    public LinkedListMap() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(K k, V v) {

    }

    @Override
    public V remove(K v) {
        return null;
    }

    @Override
    public boolean contains(K k) {
        return false;
    }

    @Override
    public V get(K k) {
        return null;
    }

    @Override
    public void set(K k, V v) {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
