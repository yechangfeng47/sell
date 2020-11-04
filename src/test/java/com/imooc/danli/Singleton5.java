package com.imooc.danli;

public class Singleton5 {

    private Singleton5(){

    }

    private static volatile Singleton5 singleton;

    public static Singleton5 getInstance(){

        if(singleton == null){
            synchronized(Singleton5.class){
                if(singleton == null){
                    singleton = new Singleton5();
                }
            }
        }
        return  singleton;
    }

    public static void main(String[] args) {
        Singleton5 s1 = Singleton5.getInstance();
        Singleton5 s2 = Singleton5.getInstance();

        System.out.println(s1 == s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }




}
