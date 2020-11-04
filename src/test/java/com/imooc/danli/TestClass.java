package com.imooc.danli;

public class TestClass {

    private static void method(){
        System.out.println("调用方法！");
    }

    public static void main(String[] args) {
//        TestClass testClass = new TestClass();
          ((TestClass)null).method();
    }

}
