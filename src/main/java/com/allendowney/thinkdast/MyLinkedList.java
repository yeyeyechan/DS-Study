package com.allendowney.thinkdast;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List<E> {

    private class Node{
        public E data;
        public Node next;

        public Node(E data, Node next){
            this.data = data;
            this.next =next;
        }
        public Node(E data){
            this.data = data;
            this.next = null;
        }
    }
    private int size;
    private Node head;
    public MyLinkedList(){
        size = 0;
        head = null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E element){
        if(head == null){
            head = new Node(element);
        }else{
            Node node = head;
            for(; node.next !=null; node = node.next){}
            node.next = new Node(element);
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if(index == -1){
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean flag = true;
        for(E ele : c ){
            flag &= add(ele);
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0 ;
    }

    public Node getNode(int index){
        if(index <0 || index >=size){
            throw new IndexOutOfBoundsException();
        }
        Node node = head;

        for(int i =0 ; i <index; i++){
            node = node.next;
        }
        return node;
    }
    @Override
    public E get(int index){
        Node node = getNode(index);
        return node.data;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element){
        if(index ==0){
            head = new Node(element, head);
        }else{
            Node node = getNode(index-1);
            node.next = new Node(element, node.next);
        }
    }

    @Override
    public E remove(int index) {
        Node node = getNode(index);
        if(index == 0 ){
            head= head.next;
        }else{
            getNode(index -1).next = getNode(index-1).next.next;
        }
        size--;
        return node.data;
    }

    private boolean equals(Object target, Object o){
        if(o ==null){
            return target ==null;
        }
        return target.equals(o) ;
    }
    @Override
    public int indexOf(Object o){
        Node node = head;
        for(int i =0 ; i< size ; i++){
            if(equals(o, node.data)){
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o ){
        Node node = head;
        int index = -1;
        for(int i = 0 ; i < size ; i++){
            if(equals(o, node.data)){
                index = i;
            }
            node = node.next;
        }
        return index;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

}
