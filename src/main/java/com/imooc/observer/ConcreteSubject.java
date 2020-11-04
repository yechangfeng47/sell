package com.imooc.observer;

/**
 * @auther zzyy
 * @create 2020-11-03 21:21
 */
public class ConcreteSubject extends  Subject{

    private String state;

    private String getState(){
        return state;
    }

    public void change(String newState){
        state = newState;
        System.out.println("主题状态为："+ state);
//        状态发生改变时，通知各个观察者
        this.notifyObservers(newState);
    }



}
