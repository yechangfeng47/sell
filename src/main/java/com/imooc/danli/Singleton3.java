package com.imooc.danli;

import java.util.Properties;

/**
 * 静态代码块饿汉式（适合复杂实例化）
 *
 */
public class Singleton3 {

    public static final Singleton3 INSTANCE;
    private String info;
    static{
        try {
            Properties pro = new Properties();
            pro.load(Singleton3.class.getClassLoader().getResourceAsStream("single.property"));
            INSTANCE = new Singleton3(pro.getProperty("info"));
        }catch(Exception e){
            throw new RuntimeException();
        }
    }
    private Singleton3(String info){
       this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    @Override
    public String toString() {
        return "Singleton3{" +
                "info='" + info + '\'' +
                '}';
    }
}
