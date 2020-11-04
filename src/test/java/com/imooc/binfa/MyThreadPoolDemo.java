package com.imooc.binfa;

import java.util.concurrent.*;

public class MyThreadPoolDemo {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
                );

            try {
                for (int i = 1; i <= 9; i++) {
                    threadPool.execute(() -> {
                        System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                    });
//                    TimeUnit.MILLISECONDS.sleep(200);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                threadPool.shutdown();
            }
    }

    private static void threadPoolInit() {
        //        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5个处理线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池1个处理线程
        ExecutorService threadPool = Executors.newCachedThreadPool();//一池N个处理线程
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
                TimeUnit.MILLISECONDS.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
