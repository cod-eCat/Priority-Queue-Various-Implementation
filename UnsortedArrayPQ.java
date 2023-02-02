package com.lpa.priorityqueue;

import java.util.NoSuchElementException;


    // TODO: 1/28/2023
    /*
    Priority Queue Implementation Using Unsorted Array
    Author - @LwinPhyoAung(cod-eCat)

    insert - O(1)
    delMax - O(N)
    delMin - O(N)

     */


public class UnsortedArrayPQ<E extends Comparable<E>> {

    private E[] pq;
    private final static int INITIAL_CAPACITY = 10;
    private int pointer;
    private int N;

    public UnsortedArrayPQ(){
        this(INITIAL_CAPACITY);
    }

    public UnsortedArrayPQ(int capacity){
        if (capacity<INITIAL_CAPACITY){
            capacity=INITIAL_CAPACITY;
        }
        pq= (E[])new Comparable[capacity];
    }

    public UnsortedArrayPQ(E[] arr){
        pq = arr;
        N = arr.length;
    }

    public void insert(E e){
        pq[pointer++] = e;
        N++;
    }

    public E max(){
        return pq[getMaxIndex()];
    }

    public E delMax(){
        int maxIndex = getMaxIndex();
        return del(maxIndex);
    }

    public E min(){
        return pq[getMinIndex()];
    }

    public E delMin(){
        int minIndex = getMinIndex();
        return del(minIndex);
    }

    public E del(int Index){
        if (pq[Index]==null){
            throw new NoSuchElementException();
        }
        if (Index==N-1){
            E res = pq[Index];
            pq[Index] = null;
            N--;
            pointer--;
            return res;
        }
        E res = pq[Index];
        pq[Index] = pq[N-1];
        pq[N-1] = null;
        N--;
        pointer--;
        return res;
    }

    private int getMaxIndex(){
        int maxI = 0;
        for (int i = 1; i<N; i++){
            if (isLess(pq[maxI], pq[i])){
                maxI = i;
            }
        }
        return maxI;
    }

    private int getMinIndex(){
        int minI = 0;
        for (int i = 1; i<N; i++){
            if (isLess(pq[i], pq[minI])){
                minI = i;
            }
        }
        return minI;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    private boolean isLess(Comparable x, Comparable y){
        return x.compareTo(y)<0;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i<pointer; i++){
            res += " " + pq[i] + " ";
        }
        return res;
    }
}
