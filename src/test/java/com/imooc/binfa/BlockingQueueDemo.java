package com.imooc.binfa;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 1 队列
 *
 * 2 队列阻塞
 *    2.1 阻塞队列有没有好的一面
 *
 *    2.2 不得不阻塞，你如何管理
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String>  blockingQueue = new ArrayBlockingQueue<String>(3);
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
//
//        System.out.println(blockingQueue.element());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());

//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("c"));
//
//        System.out.println(blockingQueue.peek());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());

//          blockingQueue.put("a");
//          blockingQueue.put("b");
//          blockingQueue.put("c");
//          blockingQueue.put("d");
//        System.out.println("=========================");
//         blockingQueue.take();
//         blockingQueue.take();
//         blockingQueue.take();
//         blockingQueue.take();

        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));


    }




}
