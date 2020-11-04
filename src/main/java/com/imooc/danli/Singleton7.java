package com.imooc.danli;

public class Singleton7 {

        private Singleton7(){

        }

        private static volatile Singleton7 singleton;

        public static Singleton7 getInstance(){

            if(singleton == null){
                synchronized(Singleton7.class){
                    if(singleton == null){
                        singleton = new Singleton7();
                    }
                }
            }
            return  singleton;
        }

        public static void main(String[] args) {
            Singleton7 s1 = Singleton7.getInstance();
            Singleton7 s2 = Singleton7.getInstance();

            System.out.println(s1 == s2);
            System.out.println(s1.hashCode());
            System.out.println(s2.hashCode());
        }


}
