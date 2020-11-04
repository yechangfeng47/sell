package com.imooc.binfa;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *  题目：多线程之间按顺序调用，实现A->B->C三个线程启动，要求如下：
 *  AA 打印5次，BB打印10次，CC打印15次
 *  紧接着
 *  AA 打印5次，BB打印10次，CC打印15次
 *  .......
 *  来10轮
 */
class ShareResource{

    private  int number = 1;//A:1 B:2 C: 3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();


    public void print5(){

        lock.lock();
        try {
            //1 判断
            while (number != 1) {
                c1.await();
            }
            //2 干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3 通知
            number = 2;
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public  void print51(){
        print(1,2,5,c1,c2);
    }

    public  void print10(){
        print(2,3,10,c2,c3);
    }

    public  void print15(){
        print(3,1,15,c3,c1);
    }

    public void print(int num,int nextNum,int count,Condition condition,Condition condition2){

        lock.lock();
        try {
            //1 判断
            while (number != num) {
                condition.await();
            }
            //2 干活
            for (int i = 1; i <= count; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3 通知
            number = nextNum;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}


public class SyncAndReentrantLockDemo {

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            for(int i= 1;i <= 10;i++){
                shareResource.print51();
            }
        },"A").start();

        new Thread(()->{
            for(int i= 1;i <= 10;i++){
                shareResource.print10();
            }
        },"B").start();

        new Thread(()->{
            for(int i= 1;i <= 10;i++){
                shareResource.print15();
            }
        },"C").start();
    }
}
