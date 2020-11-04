package com.imooc.observer;

/**
 * @auther zzyy
 * @create 2020-11-03 21:25
 */
public class ConcreteObserver implements  Observer {

    /** 观察者的状态 */
    private String observerState;

    @Override
    public void update(String state) {
        observerState = state;
        System.out.println("状态为：" + observerState);
    }

    public static void main(String[] args) {
        /** 创建主题角色 */
        ConcreteSubject concreteSubject = new ConcreteSubject();

        /** 创建观察者对象 */
        Observer observer = new ConcreteObserver();

        /** 将观察者注册到主题对象上 */
        concreteSubject.attch(observer);

        /**  改变主题对象状态 */
        concreteSubject.change("new state");
    }
}
