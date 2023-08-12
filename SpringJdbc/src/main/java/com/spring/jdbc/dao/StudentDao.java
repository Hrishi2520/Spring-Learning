package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Student;

import java.util.List;

public interface StudentDao {
    int insert(Student student);

    int change(Student student);

    int delete(int id);

    Student getStudent(int studentId);

    List<Student> getAllStudents();
}
