package com.imooc.binfa;

public class HelloGC {

    public static void main(String[] args) throws InterruptedException {

//        long totalMemory = Runtime.getRuntime().totalMemory();
//        long maxMemory = Runtime.getRuntime().maxMemory();
//        System.out.println("TOTAL_MEMORY(-Xms) =" + totalMemory + "(字节)、"+(totalMemory/(double)1024/1024)+"MB");
//        System.out.println("TOTAL_MEMORY(-Xmx) =" + totalMemory + "(字节)、"+(maxMemory/(double)1024/1024)+"MB");
        System.out.println("*********HelloGC");
        Thread.sleep(Integer.MAX_VALUE);
//        byte[] byteArray = new byte[50 * 1024 * 1024];
    }
}
