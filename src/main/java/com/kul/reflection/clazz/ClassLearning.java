package com.kul.reflection.clazz;

import com.kul.Cat;

/**
 * 对Class类特点的梳理
 */
public class ClassLearning {
    public static void main(String[] args) throws Exception {
        /**
         * 下面两种方式创建出对象,都会利用类加载器加载产生其自己的Class对象
         * 你像我们现在无论是new还是反射的方式,最终都会经由类加载器的loadClass()方法生成一个Cat.class文件或者说一个Cat类的Class对象
         * 但是需要注意类加载器的loadClass()方法只会执行一次,因为一个类的class文件只会生成一次,所以如果我们下面两行代码同时存在,后面的实际上
         * 就不会在生成.class文件了,因为类只加载一次;
         * 类加载器中方法的源码:
         *  public Class<?> loadClass(String name) throws ClassNotFoundException {
         *         return loadClass(name, false);
         *  }
         */

        Cat cat = new Cat();
        Class clazz = Class.forName("com.kul.Cat");

    }
}
