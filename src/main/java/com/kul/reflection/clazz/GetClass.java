package com.kul.reflection.clazz;

import com.kul.Car;

import java.sql.SQLOutput;

/**
 * 演示得到Class对象的各种方式
 */
public class GetClass {
    public static void main(String[] args) throws Exception {
        Car car = new Car();

        /**
         * 方式1  Class.forName()
         * 若已知一个类的全类名
         * 应用场景多用于配置文件
         */
        Class cls1 = Class.forName("com.kul.Car");

        /**
         * 方式2  类名.class
         * 若已经具体的类,通过类的class获取,该方式最为安全可靠,程序性能最高
         * Class clazz = Cat.class;
         * 应用场景多用于参数传递,比如通过反射机制得到对应的构造器对象
         */
        Class cls2 = Car.class;

        /**
         * 方式3 对象.getClass();
         * 若已知某个类的实例,则调用该实例的getClass()方法获取Class对象
         * Class clazz = 对象.getClass();
         * 应用场景多用于通过创建好的对象,获取Class对象
         */
        Class cls3 = car.getClass();

        /**
         * 方式4 通过类加载器来获取类的Class对象
         */
        ClassLoader classLoader = car.getClass().getClassLoader();
        Class cls4 = classLoader.loadClass("com.kul.Car");
        System.out.println(cls4);

        /**
         * 上述四种是比较核心的
         * 后面两种了解下就可以,主要是针对基本数据类型的
         */
        Class cls5 = int.class;
        Class cls6 = Integer.TYPE;
        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
    }
}
