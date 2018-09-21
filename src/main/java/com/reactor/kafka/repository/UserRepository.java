package com.reactor.kafka.repository;

import com.reactor.kafka.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String>, CustomUserRepository {

    public List<User> findByFirstName(String firstName);

    public List<User> findByLastName(String lastName);
}
