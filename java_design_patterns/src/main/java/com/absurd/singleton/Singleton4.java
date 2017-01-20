package com.absurd.singleton;

/***
 *  饿汉，变种
 */
public class Singleton4 {
    private static Singleton4 instance = null;
    static {
        instance = new Singleton4();
    }

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return instance;
    }
}
