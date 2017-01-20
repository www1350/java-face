package com.absurd.decoration;


import org.junit.Test;

public class FoodTest {
    @Test
    public void decorate_food(){
        Food a = new Chicken();
        Food b = new Duck();
        RoastFood r = new RoastFood(a);
        System.out.printf(""+r.getDesc());
    }
}
