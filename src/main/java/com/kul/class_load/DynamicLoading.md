package com.kul.class_load;

import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicLoading {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        switch (key) {
            case 1:
                Dog dog = new Dog();
                dog.hi();
            case 2:
                Class clazz = Class.forName("com.kul.Person");
                Object o = clazz.newInstance();
                Method hi = clazz.getMethod("hi");
                hi.invoke(o);
        }
    }
}

// 当我们把这段代码放到一个文件中,在dos环境用cmd的javac去编译时会发现一个现象;
// 会报错,因为Dog dog = new Dog() 这是静态编译,所以即使我们不知道用户传入的参数是1还是2,静态编译会把相关的类全部加载,而加载时发现找不到Dog类,所以这段代码编译都是失败的;
// 但当我们把case1中的代码注释,只有case2,会发现
// 编译ok的,因为case2中我们创建对象的方式是反射,而反射是动态加载,即既然我都不确定用户输的是1还是2,那我当然不会去提前加载Person了,用到再说了,所以动态加载时,该代码编译ok
// 但是需要注意,当真正执行时,一样会报错,因为确实没有Person类;
// 这里主要可以清晰的体现出 动态加载和静态加载的区别
// 动态加载,运行时加载需要的类,
// 静态加载,编译时会把所有相关类的进行加载;
