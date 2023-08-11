package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements org.springframework.jdbc.core.RowMapper<Student> {
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt(1));
        student.setName(resultSet.getString(2));
        student.setCity(resultSet.getString(3));
        return student;
    }
}
