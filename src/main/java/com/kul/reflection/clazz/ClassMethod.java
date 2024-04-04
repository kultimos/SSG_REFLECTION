package com.kul.reflection.clazz;

import com.kul.Car;

import java.lang.reflect.Field;

public class ClassMethod {
    public static void main(String[] args) throws Exception {
        String classAllPath = "com.kul.Car";
        Class clazz = Class.forName(classAllPath);
        System.out.println(clazz); // 显示clazz对象是哪个类的Class对象
        System.out.println(clazz.getClass()); // 显示clazz运行类型 java.lang.Class
        System.out.println(clazz.getPackage().getName()); // 显示clazz对象对应的类的包名
        System.out.println(clazz.getName()); //显示clazz对象对应的全类名
        Object o = clazz.newInstance(); //通过clazz对象创建一个对象实例
        Car car = (Car) o;
        System.out.println(car);
        Field brand = clazz.getField("brand");
        System.out.println(brand.get(car));  // 通过clazz对象得到具体的属性信息 但需要注意私有属性无法通过getField获取
        brand.set(car,"沃尔沃"); //可以对对象属性进行操作
        System.out.println(brand.get(car));
    }
}
