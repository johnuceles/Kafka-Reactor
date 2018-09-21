package com.reactor.kafka.service;

import com.reactor.kafka.model.User;

import java.util.List;

public interface UserService {

    User getUser(String id);

    List<User> getUsersByFirstName(String firstName);

    List<User> getUsersByLastName(String lastName);

    List<User> getAllUsers();

    List<User> getAllUsersPaginated(int pageNumber, int pageSize);
}