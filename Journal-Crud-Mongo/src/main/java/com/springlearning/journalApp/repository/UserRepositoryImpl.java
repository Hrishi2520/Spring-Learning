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
//        query.addCriteria(Criteria.where("email").exists(true));
        Criteria criteria = new Criteria();
        query.addCriteria(criteria.orOperator(
                Criteria.where("email").exists(true),
                Criteria.where("email").ne(null).ne(""),
                Criteria.where("sentimentAnalysis").is(true),
                Criteria.where("roles").in("USER", "ADMIN")
                )
        );
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }
}
