package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpl implements StudentDao{

    private JdbcTemplate template;
    public int insert(Student student) {
        String query = "insert into student(id, name, city) values(?, ?, ?)";
        int r = this.template.update(query, student.getId(), student.getName(), student.getCity());
        return r;
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
}
