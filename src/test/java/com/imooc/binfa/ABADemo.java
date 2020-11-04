package com.imooc.binfa;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo //ABA 问题的解决
 {
     static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

     static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);
     public static void main(String[] args) {

         System.out.println("=============以下是ABA问题的产生===============");
         new Thread(()->{
             atomicReference.compareAndSet(100,101);
             atomicReference.compareAndSet(101,100);
         },"t1").start();
         new Thread(()->{
          // 暂停1秒钟t2 线程，保证上面的t1线程完成一次ABA操作
             try {
                 TimeUnit.SECONDS.sleep(1);
                 System.out.println(atomicReference.compareAndSet(100,2019)+"\t"+ atomicReference.get());
             }catch (InterruptedException e){
                   e.printStackTrace();
             }
         },"t2").start();

         System.out.println("=============以下是ABA问题的解决===============");
         new Thread(()->{
             int stamp = atomicStampedReference.getStamp();
             System.out.println(Thread.currentThread().getName()+"\t第1次版本号："+stamp);
             try {
                 TimeUnit.SECONDS.sleep(1);
                 atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
                 System.out.println(Thread.currentThread().getName()+"\t第2次版本号："+atomicStampedReference.getStamp());
                 atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
                 System.out.println(Thread.currentThread().getName()+"\t第3次版本号："+atomicStampedReference.getStamp());
             }catch (InterruptedException e){
                 e.printStackTrace();
             }
         },"t3").start();

         new Thread(()->{
             int stamp = atomicStampedReference.getStamp();
             System.out.println(Thread.currentThread().getName()+"\t第1次版本号："+stamp);
             try {
                 TimeUnit.SECONDS.sleep(3);
                boolean result = atomicStampedReference.compareAndSet(100,2019,stamp,stamp+1);
                 System.out.println(Thread.currentThread().getName()+"\t修改成功与否" + result+"当前实际版本号："+atomicStampedReference.getStamp());
                 System.out.println(Thread.currentThread().getName()+"\t当前实际版本号："+atomicStampedReference.getStamp());
             }catch (InterruptedException e){
                 e.printStackTrace();
             }
         },"t4").start();

     }


}
