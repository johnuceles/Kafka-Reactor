package com.reactor.kafka.repository;

import com.reactor.kafka.model.User;

import java.util.List;

public interface CustomUserRepository {

    List<User> getAllUsersPaginated(int pageNumber, int pageSize);
}