package com.springlearning.journalApp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryImplTests {

//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    public List<User> getUsersForSentimentAnalysis() {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("namw").is("ram"));
//        List<User> users = mongoTemplate.find(query, User.class);
//        return users;
//    }

    @Autowired
    private UserRepositoryImpl userRepository;

    public void testSaveNewUser() {
        userRepository.findUserForSA();
    }
}
