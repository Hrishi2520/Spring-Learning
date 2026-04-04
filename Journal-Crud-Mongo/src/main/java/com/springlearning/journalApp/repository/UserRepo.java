package com.springlearning.journalApp.repository;

import com.springlearning.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, ObjectId> {
    User findByUserName(String name);

    void deleteByUserName(String userName);
}
