package com.kul.service;

import com.kul.po.Student;

public interface IStudentService {

    void save(Student student);

    Student query(Long id);
}
