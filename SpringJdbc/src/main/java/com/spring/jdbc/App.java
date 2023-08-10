package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "My Program Started......!" );
//        spring jdbc=> JdbcTemplate
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        Student student = new Student(235, "Hritik", "dehli");

        int result = studentDao.delete(22);

        System.out.println("Student deleted "+ result);


    }
}
