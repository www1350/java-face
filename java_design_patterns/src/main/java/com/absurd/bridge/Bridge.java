package com.absurd.bridge;


public abstract class Bridge {
    private Service service;

    public void method1() {
        service.method1();
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
