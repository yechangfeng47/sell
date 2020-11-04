package com.imooc.list;

public class MyArrayList {

    //整个集合中最关键的部分，得有一个数组来保存数据
      private Object[] elementDate;
    //再来一个很关键的，数组会有长度，保存几个数据长度就为几
      private int size;
    /**
     * 通过构造方法，把一些初始化的事情办了
     */

    public MyArrayList(){
        elementDate = new Object[10];
    }

    public void add(Object obj){
        if(size >= elementDate.length){
            Object[] temp = new Object[elementDate.length * 3/2];
            System.arraycopy(elementDate,0,temp,0,elementDate.length);
            elementDate = temp;
        }
        elementDate[size++] =  obj;
    }
}
