package com.reactor.kafka.service.impl;

import com.reactor.kafka.model.User;
import com.reactor.kafka.repository.UserRepository;
import com.reactor.kafka.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(String id) {

        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public List<User> getUsersByFirstName(String firstName) {

        return userRepository.findByFirstName(firstName);
    }

    @Override
    public List<User> getUsersByLastName(String lastName) {

        return userRepository.findByLastName(lastName);
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public List<User> getAllUsersPaginated(int pageNumber, int pageSize) {

        return userRepository.getAllUsersPaginated(pageNumber, pageSize);
    }

}