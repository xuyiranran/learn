package learnData.setAndmap;

import learnData.linklist.LinkedList;

public class LinkedListSet<E extends Comparable<E>> implements Set<E> {

    private LinkedList<E> linkedList;


    public LinkedListSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int size() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void add(E e) {
        if (linkedList.contains(e)) return;
        linkedList.addFirst(e);
    }

    @Override
    public void remove(E e) {
        linkedList.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    public static void main(String[] args) {

        Set<String> listset = new LinkedListSet<>();
        listset.add("hello");
        listset.add("hello");
        listset.add("hello");
        listset.add("hello");

        listset.add("world");
        listset.add("test");
        listset.remove("test");

        System.out.println(listset.size());

    }

}
