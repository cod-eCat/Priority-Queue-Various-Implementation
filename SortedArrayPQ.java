package com.lpa.priorityqueue;


import java.util.NoSuchElementException;

    // TODO: 1/28/2023
    /*
    Priority Queue Implementation Using Sorted Array
    Author - @LwinPhyoAung(cod-eCat)
    insert - O(N)
    delMax - O(1)
     */


public class SortedArrayPQ <E extends Comparable<E>>{

    private E[] pq;
    private final static int INITIAL_CAPACITY = 10;
    private int pointer;
    private int N;

    public SortedArrayPQ(){
        this(INITIAL_CAPACITY);
    }

    public SortedArrayPQ(int capacity){
        if (capacity<INITIAL_CAPACITY){
            capacity = INITIAL_CAPACITY;
        }
        pq = (E[]) new Comparable[capacity];
    }

    public SortedArrayPQ(E[] arr){
        pq = arr;
        N = arr.length;
    }

    public void insert(E e){
        int i = 0;
        while ((i< N) && isLess(pq[i], e)){
            i++;
        }
        forwardShift(i);
        pq[i] = e;
        N++;
    }

    public E max(){
        return pq[N -1];
    }

    public E delMax(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        E max = pq[N -1];
        pq[--N] = null;
        return max;
    }

    private void forwardShift(int index){
        for (int i = N -1; i>index; i--){
            pq[i] = pq[i-1];
        }
    }

    private boolean isLess(Comparable x, Comparable y){
        return x.compareTo(y)<0;
    }

    public boolean isEmpty(){
        return N ==0;
    }

    public int size(){
        return N;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i<pq.length; i++){
            result += " " + pq[i] + " ";
        }
        return result;
    }
}
