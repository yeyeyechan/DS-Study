package com.allendowney.thinkdast;

import java.util.List;

public class MyLinkedList<E> implements List<E> {
    private int size;
    private Node head;

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
    public MyLinkedList(){
        size = 0;
        head = null;
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
}
