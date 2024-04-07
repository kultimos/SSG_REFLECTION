package com.kul.cglib.interceptor;

import com.kul.service.IStudentService;
import com.kul.transcation.DaoTransaction;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibInterceptor implements MethodInterceptor {

    DaoTransaction daoTransaction;
    IStudentService studentService;
    public CglibInterceptor(DaoTransaction daoTransaction) {
        this.daoTransaction = daoTransaction;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        daoTransaction.before();
        System.out.println(method.getName());
        Object o1 = methodProxy.invokeSuper(o, objects);
        daoTransaction.after();
        return o1;
    }
}
