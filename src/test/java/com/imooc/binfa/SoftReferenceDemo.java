package com.imooc.binfa;

import java.lang.ref.SoftReference;

/**
 *
 * 软引用
 *
 */
public class SoftReferenceDemo {

    public static void  softRef_Memory_Enough(){

        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<Object>(o1);

        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(softReference.get());

    }

    public static void softRef_Memory_NotEnough(){

        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<Object>(o1);

        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();

        try{
            byte[] bytes = new byte[30 * 1024 *1024];
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }

    }


    public static void main(String[] args) {
//        softRef_Memory_Enough();
        softRef_Memory_NotEnough();
    }
}
