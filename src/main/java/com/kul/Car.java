package com.kul;

public class Car {
    public String brand="宝马";
    public int price=1000;
    public String color="white";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
