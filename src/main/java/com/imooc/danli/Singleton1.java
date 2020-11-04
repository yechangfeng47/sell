package com.imooc.danli;

/**
 * 直接实例化饿汉式（简介直观）
 *
 * 饿汉式：
 *   直接创建实例对象，不管是否需要这个对象
 *
 *  (1)构造器私有化
 * （2）自行创建，并且用静态变量保存
 * （3）向外提供这个实例
 * （4）强调这是一个单例，我们可以用final修改
 */
public class Singleton1 {

    public static final Singleton1 INSTANCE  = new Singleton1();
    private Singleton1(){
    }
}
