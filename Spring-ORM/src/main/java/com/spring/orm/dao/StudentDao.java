package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class StudentDao {

    private HibernateTemplate hibernateTemplate;

    //save student
    @Transactional
    public int insert(Student student) {
        //insert
        Integer r = (Integer) this.hibernateTemplate.save(student);
        return r;
    }

    //get the single data(object)
    public Student getStudent(int id) {
        Student s = this.hibernateTemplate.get(Student.class, id);
        return s;
    }

    //get all students(all rows)
    public List<Student> getAllStudents() {
        List<Student> students = this.hibernateTemplate.loadAll(Student.class);
        return students;
    }

    //deleting the data
    @Transactional
    public void deleteStudents(int studentId) {
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        this.hibernateTemplate.delete(student);
    }

    //updating data..
    @Transactional
    public void updateStudent(Student student) {
        this.hibernateTemplate.update(student);
    }
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
