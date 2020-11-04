package com.imooc.kejianxing;

import com.imooc.threadtest.Threed005;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData {

   volatile int num = 0;

    public void addTo60() {
        this.num = 60;
    }

    public  void addPlusPlus(){
        num++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }

}


public class VolatileDemo{

    public static void main(String[] args) {

         MyData myData = new MyData();

         for(int i= 1;i <= 20;i++){
             new Thread(()-> {
                 for(int j = 1;j <=1000;j++ ){
                     myData.addPlusPlus();
                     myData.addMyAtomic();
                 }
             },String.valueOf(i)).start();
         }

       //需要等待上面20个线程全部执行完成后，再用main线程取得最终的结果值是多少
         while(Thread.activeCount() > 2){
             Thread.yield();
         }

        System.out.println(Thread.currentThread().getName()+"\t int type,fianlly number value" + myData.num);
        System.out.println(Thread.currentThread().getName()+"\t atomicInteger type,fianlly number value" + myData.atomicInteger);

    }

    //volatile 可以保证可见性，及时通知其他线程，主物理内存的值已经被修改
    private static void setOkByVolatile() {
        MyData myData = new MyData();
        new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+"\t come in");

            try {
                TimeUnit.SECONDS.sleep(3);
                myData.addTo60();
                System.out.println(Thread.currentThread().getName()+"\t update number value" + myData.num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"AAA").start();


        while(myData.num == 0){

        }

        System.out.println(Thread.currentThread().getName()+"\t mission is over,main get number value:"+myData.num);
    }
}
