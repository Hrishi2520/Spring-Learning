package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements StudentDao{

    private JdbcTemplate template;
    public int insert(Student student) {
        String query = "insert into student(id, name, city) values(?, ?, ?)";
        int r = this.template.update(query, student.getId(), student.getName(), student.getCity());
        return r;
    }

    public int change(Student student) {
        String query = "update student set name= ?, city=? where id=?";
        int r = this.template.update(query,student.getName(),student.getCity(), student.getId());
        return r;
    }

    public int delete(int id) {
        String query = "delete from student where id=?";
        int r = template.update(query,id);
        return r;
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public Student getStudent(int studentId) {
        String query = "select * from student where id=?";
        Student student = this.template.queryForObject(query, new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student1 = new Student();
                student1.setId(resultSet.getInt(1));
                student1.setName(resultSet.getString(2));
                student1.setCity(resultSet.getString(3));
                return student1;
            }
        }, studentId);
        return student;
    }
}
