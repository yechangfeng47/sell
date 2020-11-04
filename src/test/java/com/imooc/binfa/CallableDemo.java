package com.imooc.binfa;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("******************come in Callable");
        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask futureTask = new FutureTask(new MyThread());
        new Thread(futureTask,"AA").start();

        System.out.println(Thread.currentThread().getName()+"******************");


        int result01 = 100;
        while (!futureTask.isDone()){

        }
        int result02 = (int) futureTask.get();//建议放在最后
        System.out.println("************* result"+(result01+result02));
    }


}
