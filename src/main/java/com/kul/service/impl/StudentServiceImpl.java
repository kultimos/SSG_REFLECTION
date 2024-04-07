package com.kul.service.impl;

import com.kul.po.Student;
import com.kul.service.IStudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

    @Override
    public void save(Student student) {
        System.out.println("保存学生信息");
    }

    @Override
    public Student query(Long id) {
        System.out.println("查询操作");
        Student student = new Student();
        student.setName("wu");
        student.setAge(23);
        return student;
    }
}
