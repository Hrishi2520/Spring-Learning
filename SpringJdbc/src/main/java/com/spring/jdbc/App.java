package com.spring.jdbc;

import com.spring.jdbc.config.JdbcConfig;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        List<Student> students = studentDao.getAllStudents();
        students.forEach(System.out::println);


    }
}
