package com.kul;

import com.kul.cglib.interceptor.CglibInterceptor;
import com.kul.handler.TransactionHandler;
import com.kul.po.Student;
import com.kul.service.IStudentService;
import com.kul.service.impl.StudentServiceImpl;
import com.kul.transcation.DaoTransaction;
import net.sf.cglib.proxy.Enhancer;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@SpringBootTest
class SsgReflectionApplicationTests {

    @Test
    public void JDKSave() throws Exception {
        DaoTransaction daoTransaction = new DaoTransaction();
        IStudentService studentService = new StudentServiceImpl();
        TransactionHandler transactionHandler = new TransactionHandler(daoTransaction, studentService);
        IStudentService o = (IStudentService) Proxy.newProxyInstance(StudentServiceImpl.class.getClassLoader(), StudentServiceImpl.class.getInterfaces(), transactionHandler);
        Student student = new Student();
        student.setName("k");
        student.setAge(16);
        o.save(student);
        System.out.println(o);
    }

    @Test
    public void CglibSave() throws Exception {
        CglibInterceptor cglibInterceptor = new CglibInterceptor(new DaoTransaction());
        // 使用CBLIB框架生成目标类的子类(代理类)实现增强
        Enhancer enhancer = new Enhancer();
        //设置父类字节码
        enhancer.setSuperclass(StudentServiceImpl.class);
        //设置拦截处理
        enhancer.setCallback(cglibInterceptor);
        StudentServiceImpl o = (StudentServiceImpl)enhancer.create();
        Student student = new Student();
        student.setName("吴磊");
        student.setAge(99);
        o.save(student);
    }
}
