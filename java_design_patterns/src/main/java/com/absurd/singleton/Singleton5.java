package com.absurd.singleton;

/***
 *  静态内部类
 */
public class Singleton5 {
    private static class SingleHolder{
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    private Singleton5() {
    }

    public static Singleton5 getInstance(){
      return   SingleHolder.INSTANCE;
    }
}
