package com.imooc.threadtest;

public class Thread006 {

    public static void main(String[] args)  {
       Thread t1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 20;i ++){
                    System.out.println("线程t1，i:"+ i);
                }
            }
        });
        t1.start();

        Thread t2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i = 0;i < 20;i ++){
                    System.out.println("线程t2，i:"+ i);
                }
            }
        });

        t2.start();

        Thread t3 =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i = 0;i < 20;i ++){
                    System.out.println("线程t3，i:"+ i);
                }
            }
        });

        t3.start();
    }

}
