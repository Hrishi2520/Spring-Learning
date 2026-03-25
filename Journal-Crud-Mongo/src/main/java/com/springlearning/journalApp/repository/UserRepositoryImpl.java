package com.springlearning.journalApp.repository;

import com.springlearning.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class UserRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> findUserForSA() {
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is("ram"));
        query.addCriteria(Criteria.where("age").gte(20));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }
}
