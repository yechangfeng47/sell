package com.imooc.binfa;

import java.util.concurrent.TimeUnit;

class HoldLockThread implements  Runnable{

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {

        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有"+lockA+"尝试获得"+lockB);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 自己持有"+lockB +"尝试获得"+lockA);
            }
        }


    }
}
/**
 *
 * 死锁是指两个或两个以上进程在执行过程中，
 * 因争夺资源而造成的一种互相等待现象，
 * 若无外力干涉他们都将无法推行下去
 *
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA,lockB),"ThreadAAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"ThreadBBB").start();

        /**
         *
         * linux  ps -ef|grep ***  ls -l
         *
         * windows 下的java 运行程序 也有类似的ps 查看进程命令，但是目前我们需要看的只是java
         *  jps = java ps  jps -l
         *
         */

    }
}
