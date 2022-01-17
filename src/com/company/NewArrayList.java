package com.company;

public interface NewArrayList<T> {
    void add(T element);
    void add(int index,T element);
    void set(int index,T element);
    T get(int index);
    boolean remove(int index);
    int size();
    void clear();
    boolean isEmpty();

}
