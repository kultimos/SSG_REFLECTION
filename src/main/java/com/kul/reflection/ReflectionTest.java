package com.kul.reflection;

import com.kul.Cat;

import java.lang.reflect.Method;

/**
 * 测试反射调用的性能及其优化方案
 */
public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        m1();
        m2();
    }

    /**
     * 传统方式调用
     */
    public static void m1() {
        long start = System.currentTimeMillis();
        Cat cat = new Cat();
        for(int i=0;i<90000000;i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方式耗时: " + (end-start)); // 4
    }


    /**
     * 反射方式调用
     */
    public static void m2() throws Exception {
        long start = System.currentTimeMillis();
        Class clazz = Class.forName("com.kul.Cat");
        Object o = clazz.newInstance();
        Method hi = clazz.getMethod("hi");
        hi.setAccessible(true); // 加上以后可以发现性能确实提高了,但是跟传统方式依然没有可比性 120
        for(int i=0;i<90000000;i++) {
            hi.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射方式耗时: " + (end-start)); // 214
    }
}
