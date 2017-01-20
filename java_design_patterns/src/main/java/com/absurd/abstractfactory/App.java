package com.absurd.abstractfactory;

/***
 *
 */
public class App {

    private String desc ;
    public void createApp(final AbstractFactory factory){
        desc = factory.getDesc();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
