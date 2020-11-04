package com.imooc.threadtest;

public class Threed005 {
    public static void main(String[] args) {
       Thread thread =  new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 60;i++){
                    System.out.println("子线程，i:"+i);
                }
            }
        });
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0;i < 30;i ++){
            System.out.println("主线程，i:"+ i);
        }
    }
}
