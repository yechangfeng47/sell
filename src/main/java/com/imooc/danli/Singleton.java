package com.imooc.danli;

/**
 * @auther zzyy
 * @create 2020-10-28 15:03
 */
public class Singleton {

    private Singleton(){
    }



    private static class Inner{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static final Singleton getInstance(){
        return Inner.INSTANCE;
    }

}
