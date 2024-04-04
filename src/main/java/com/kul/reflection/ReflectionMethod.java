package com.kul.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionMethod {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\main\\resources\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();


        Class clazz = Class.forName(classfullpath);
        Object o = clazz.newInstance();
        Method method = clazz.getMethod(methodName);

        //注意: getField无法得到私有的属性
        Field ageField = clazz.getField("age");
        System.out.println(ageField.get(o)); //反过来了 这里的打印结果跟 o.name 一致

        //在getConstructor()中可以指定构造器参数类型,没写就是得到一个无参构造器
        Constructor constructor = clazz.getConstructor();
        System.out.println(constructor);

        Constructor constructor1 = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor1);


    }
}
