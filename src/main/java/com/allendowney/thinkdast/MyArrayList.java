package com.allendowney.thinkdast;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    int size;
    private E[] array;

    public MyArrayList(){
        array = (E[]) new Object[10];
        size = 0;
    }
    @Override
    public boolean add( E element){
        if(size >= array.length){
            E[] newArray = (E[]) new Object[2*array.length];
            System.arraycopy(array, 0, newArray, 0, array.length);
        }
        array[size] = element;
        size++;
        return true;
    }
    @Override
    // 확인
    public boolean addAll(int index, Collection<? extends  E> c){
        int idx = index;
        for(E ele : c){
            add(idx, ele);
            idx++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag = true;
        for(Object ele : c ){
            flag &= remove(ele);
        }
        return true;
    }

    @Override
    //확인
    public boolean retainAll(Collection<?> c) {
        boolean flag =true;
        for(Object ele  : c){
            if(indexOf(ele) != -1){
                flag &= remove(ele);
            }
        }
        return flag;
    }

    @Override
    public void clear(){
        size = 0 ;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size ==0 ;
    }

    @Override
    public boolean contains(Object o ){
        return indexOf(o) != -1 ;
    }

    @Override
    public Iterator<E> iterator() {
        E [] copy =Arrays.copyOf(array, size);
        return Arrays.asList(copy).iterator();
    }

    @Override
    public Object[] toArray() {
        E [] copy =Arrays.copyOf(array, size);

        return copy;
    }

    @Override
    //확인
    public <T> T[] toArray(T[] a) {

        return null;
    }

    @Override
    public boolean containsAll(Collection<?> o ){
        boolean flag = true;
        for(Object ele : o ){
            if(!contains(ele)){
                return false;
            }
        }
        return flag;
    }

    @Override
    public E get(int index){
        if(index<0||index >=size){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public E set(int index, E element){
        if(index <0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        E old = array[index];

        array[index] = element;

        return old;
    }

    @Override
    public void add (int index, E element){
        if(index <0 || index >=size){
            throw new IndexOutOfBoundsException();
        }
        add(element);
        for( int i=(size-1) ; i>index ; i--){
            array[i] = array[i-1];
        }
        array[index] = element;

    }
    private boolean equals(Object target, Object element){
        if(element == null){
            return target == null;
        }
        return target.equals(element);
    }
    @Override
    public int indexOf(Object element){
        for(int i = 0 ; i < size ; i++){
            if(equals(array[i], element)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = size-1; i >=0; i--){
            if(equals(o,array[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        E[] copy = Arrays.copyOf(array, size);
        return Arrays.asList(copy).listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        E[] copy = Arrays.copyOf(array, size);
        return Arrays.asList(copy).listIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if(fromIndex <0 || toIndex>=size || fromIndex > toIndex){
            throw new IndexOutOfBoundsException();
        }
        E [] copy = Arrays.copyOfRange(array, fromIndex, toIndex);

        return Arrays.asList(copy);
    }

    @Override
    public boolean addAll(Collection<? extends E > element) {
        boolean flag = true;
        for(E ele : element){
            flag &=add(ele);
        }
        return flag;
    }

    @Override
    public E remove(int index){
        E element = get(index);
        for(int i= index; i < size-1; i++){
            array[i]= array[i+1];
        }
        size--;
        return element;
    }
    @Override
    public boolean remove(Object o ){
        int index = indexOf(o);

        if(index == -1){
            return false;
        }
        remove(index);
        return true;
    }

}
