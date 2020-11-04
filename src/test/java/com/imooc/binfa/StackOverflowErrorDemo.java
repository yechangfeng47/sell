package com.imooc.binfa;

/**
 *
 * 栈溢出
 *  栈空间 一般默认512m 1024m
 *   栈管运行
 */
public class StackOverflowErrorDemo {

    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }

}
