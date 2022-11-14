package com.Admin_Service.repository;

import com.Admin_Service.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface UserRepository extends MongoRepository<User, ObjectId> {

    @Query("{username:\"?0\"}")
    List<User> loginUser(String username);

}
