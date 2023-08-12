package com.spring.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.spring.jdbc.dao")
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


}
