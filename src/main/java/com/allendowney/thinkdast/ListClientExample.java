package com.allendowney.thinkdast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListClientExample {
    private List list;

    public ListClientExample(){
        list = new ArrayList();
    }

    public List getList(){
        return list;
    }

    public static void main (String[] args){
        ListClientExample Ice = new ListClientExample();
        List list = Ice.getList();
        System.out.println(list);
    }

}
