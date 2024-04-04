package com.kul;


public class Cat {
    private String name = "招财猫";
    public int age = 10;

    public  Cat(){}

    public Cat(String name, int age) {
        this.age = age;
        this.name = name;
    }
    public void hi() {
//        System.out.println("hi" + name);
    }

    public void cry() {
        System.out.println("小猫咪哇哇哭");
    }
}
