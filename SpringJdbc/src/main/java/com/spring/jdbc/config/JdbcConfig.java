package com.spring.jdbc.config;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {
    @Bean("ds")
    public DataSource getDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://Localhost:3306/springjdbc");
        ds.setUsername("root");
        ds.setPassword("angrybird");
        return ds;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getTemplate() {
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(getDataSource());
        return template;
    }

    @Bean("studentDao")
    public StudentDao getStudent() {
        StudentDaoImpl dao = new StudentDaoImpl();
        dao.setTemplate(getTemplate());
        return dao;
    }


}
