package com.absurd.classloader;

/***
 *
 */
public class Simple {
    private Simple instance;

    public void setSimple(Object instance) {
        this.instance = (Simple) instance;
    }
}
