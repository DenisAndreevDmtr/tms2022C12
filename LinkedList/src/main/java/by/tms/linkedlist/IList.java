package by.tms.linkedlist;

public interface IList {
    boolean add(Object data);

    boolean contains(Object data);

    boolean remove(Object data);

    boolean remove(int index);

    Object set(int index, Object newData);

    Object get(int index);

    void clear();

    int size();

    Object getLast();

    Object getFirst();

    boolean addAll(IList c);

}