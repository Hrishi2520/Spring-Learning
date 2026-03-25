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

    public List<User> getUsersForSentimentAnalysis() {
        Query query = new Query();
        query.addCriteria(Criteria.where("namw").is("ram"));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }
}
