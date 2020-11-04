package com.imooc.binfa;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapDemo {


    private static void myHashMapDemo(){
        HashMap<Integer,String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";
        map.put(key,value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }

    private static void myWeakHashMap(){
        WeakHashMap<Integer,String> map = new WeakHashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";
        map.put(key,value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }

    public static void main(String[] args) {
        myHashMapDemo();
        System.out.println("=======================");
        myWeakHashMap();
    }
}
