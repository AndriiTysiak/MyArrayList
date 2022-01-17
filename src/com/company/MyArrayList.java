package com.company;

import java.util.Arrays;

public class MyArrayList<T> implements NewArrayList<T> {
    private static double maxLoadArrayList = 0.50;
    private static int startLengthOfArrayList = 7;
    private int pointer = 0;
    private T[] arrayList;

    public MyArrayList() {
        arrayList = (T[]) new Object[startLengthOfArrayList];
    }

    public MyArrayList(int capacity) {
        arrayList = (T[]) new Object[capacity];
    }

    @Override
    public void add(T element) {
        increaseArrayLenght();
        arrayList[pointer++] = element;
    }

    private void increaseArrayLenght() {
        if ((double) pointer / (double) arrayList.length > maxLoadArrayList) {
            T[] newArrayList = Arrays.copyOf(arrayList, arrayList.length * 2);
            arrayList = newArrayList;
        }
    }

    @Override
    public void add(int index, T element) {
        if (!isCorrectRange(index)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        increaseArrayLenght();
        pointer++;
        for (int i = pointer; i > 1; i--) {
            arrayList[i] = arrayList[i - 1];
        }
        arrayList[index] = element;
    }

    @Override
    public void set(int index, T element) {
        if (!isCorrectRange(index)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        arrayList[index] = element;
    }

    private boolean isCorrectRange(int index) {
        return index >= 0 && index < pointer;
    }

    @Override
    public T get(int index) {
        if (!isCorrectRange(index)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return arrayList[index];
    }

    @Override
    public boolean remove(int index) {
        for (int i = index; i < pointer; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        pointer--;
        return true;
    }

    @Override
    public int size() {
        return pointer;
    }

    @Override
    public void clear() {
        arrayList = (T[]) new Object[startLengthOfArrayList];
        pointer = 0;
    }

    @Override
    public boolean isEmpty() {
        return pointer == 0;
    }
}
