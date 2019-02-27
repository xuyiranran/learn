package learnData.setAndmap;

public interface Map<K,V> {

    void add(K k,V v);

    V remove(K v);

    boolean contains(K k);

    V get(K k);

    void set(K k,V v);

    int getSize();

    boolean isEmpty();

}
