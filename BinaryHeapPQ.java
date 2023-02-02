package com.lpa.priorityqueue;

    // TODO: 1/29/2023
    /*
    Priority Queue Implementation Using BinaryHeap

    insert - O(logN)
    delMax - O(logN)
     */

import java.util.NoSuchElementException;

public class BinaryHeapPQ <E extends Comparable<E>>{

    private E[] pq;
    private int pointer;
    private static final int INITIAL_CAPACITY=10;
    private int size;

    public BinaryHeapPQ(){
        pq = (E[]) new Comparable[INITIAL_CAPACITY];
    }

    public BinaryHeapPQ(int capacity){
        if (capacity<INITIAL_CAPACITY){
            capacity=INITIAL_CAPACITY;
        }
        pq = (E[]) new Comparable[capacity];
    }

    public void insert(E e){
        pq[++pointer] = e;
        up(pointer);
        size++;
    }

    public E max(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return pq[1];
    }

    public E delMax(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        E max = pq[1];
        size--;
        swap(1, pointer);
        pointer--;
        down(1);
        pq[pointer+1] = null;
        return max;
    }

    private void up(int i){
        while ( (i>1) && (isLess(pq[i/2], pq[i])) ){
            swap(i/2, i);
            i/=2;
        }
    }

    private void down(int i){
        while ( (i*2) <= pointer ){
            int s = i*2;
            if ( (s) < pointer && isLess(pq[s], pq[s+1])){
                s += 1;
            }
            if (!isLess(pq[i], pq[s])){
                break;
            }
            swap(i, s);
            i=s;
        }
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    private boolean isLess(Comparable x, Comparable y){
        return x.compareTo(y)<0;
    }

    private void swap(int x, int y){
        E temp = pq[x];
        pq[x] = pq[y];
        pq[y] = temp;
    }

    @Override
    public String toString() {

        String res = "";
        for (int i = 1; i<=pointer; i++){
            res += " " + pq[i] + " ";
        }
        return res;

    }
}
