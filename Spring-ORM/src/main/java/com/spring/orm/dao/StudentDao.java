package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;

public class StudentDao {

    private HibernateTemplate hibernateTemplate;

    //save student
    @Transactional
    public int insert(Student student) {
        //insert
        Integer r = (Integer) this.hibernateTemplate.save(student);
        return r;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
