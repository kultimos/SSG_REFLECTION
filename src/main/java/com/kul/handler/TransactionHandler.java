package com.kul.handler;

import com.kul.service.IStudentService;
import com.kul.transcation.DaoTransaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TransactionHandler implements InvocationHandler {

    private DaoTransaction daoTransaction;
    private IStudentService studentService;

    public TransactionHandler(DaoTransaction daoTransaction,IStudentService studentService) {
        this.daoTransaction = daoTransaction;
        this.studentService = studentService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         * InvocationHandler 是用来做方法拦截的
         * proxy: 一个代理实例, 拥有newProxyInstance方法,基于此进行反射形式的对象实例创建
         * method: 要进行增加的代理对象的目标方法
         * args: 参数列表
         */
        if("save".equals(method.getName())){
            System.out.println("进入拦截器");
            daoTransaction.before();
            Object invoke = method.invoke(studentService, args);
            daoTransaction.after();
            return invoke;
        }
        return null;
    }
}
