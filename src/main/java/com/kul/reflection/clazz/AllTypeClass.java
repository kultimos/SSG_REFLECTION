package com.kul.reflection.clazz;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AllTypeClass {
    public static void main(String[] args) {
        Class<String> stringClass = String.class; // 外部类
        Class<Integer[]> aClass = Integer[].class; // 数组
        Class<Serializable> serializableClass = Serializable.class; // 接口
        Class<Controller> controllerClass = Controller.class; //注解
        Class<Thread.State> stateClass = Thread.State.class; //枚举
        Class<Long> longClass = long.class; //基本类型
        Class<Void> voidClass = void.class; // void
        Class<Class> classClass = Class.class; // Class本身也是一个类,所以他也有Class对象
    }
}
