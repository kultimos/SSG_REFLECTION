package com.kul.reflection.question;


import com.kul.Cat;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射问题的引入
 */
public class ReflectionQuestion {
    public static void main(String[] args) throws Exception {
        //根据re.properties的信息,创建Cat对象并调用方法hi

        //尝试用读取文件流的方式去实现需求,行不通
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\main\\resources\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();

        // 使用反射实现需求

        //1 加载类
        Class clazz = Class.forName(classfullpath);

        //2 通过这个类对象可以得到加载类的对象实例
        Object o = clazz.newInstance();

        //3 通过这个类对象的methodName,得到一个方法对象
        //即在反射中 可以把方法视为对象(万物皆对象)
        Method method = clazz.getMethod(methodName);


        //4 通过方法对象来实现调用方法  方法.invoke(对象)
        method.invoke(o);
    }
}
