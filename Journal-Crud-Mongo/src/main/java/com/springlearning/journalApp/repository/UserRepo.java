package com.springlearning.journalApp.repository;

import com.springlearning.journalApp.entity.JournalEntry;
import com.springlearning.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, ObjectId> {
    @Query("SELECT u FROM User u Where u.userName=:name")
    User findByUserName(@Param("name") String name);

    void deleteByUserName(String userName);
}
