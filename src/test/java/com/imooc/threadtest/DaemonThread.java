package com.imooc.threadtest;

public class DaemonThread {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 30;i++){
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程，i:"+ i);
                }
            }
        });
        //该线程为守护线程，和主线程一起销毁
        t1.setDaemon(true);
        t1.start();
        for(int i = 0;i < 5;i++){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程，i:" + i);
        }
        System.out.println("主线程执行完毕。。。。。。。。。");
    }
}
