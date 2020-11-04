package com.imooc.danli;

public class TestInteger {

    public static void main(String[] args) {

        int i = 0;
        Integer j = new Integer(0);

        Integer k = new Integer(0);

        System.out.println(i == j);
        System.out.println(j.equals(i));

        System.out.println(k == j);
        System.out.println(j.equals(k));
    }
}
