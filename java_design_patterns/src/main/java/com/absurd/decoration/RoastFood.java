package com.absurd.decoration;


public class RoastFood extends FoodDecoration {
    private Food food;

    public RoastFood(Food food) {
        this.food = food;
    }

    private String getDecoration() {
        return "烤";
    }

    @Override
    public String getDesc() {
        return getDecoration()+food.getDesc();
    }
}
