package com.reactor.kafka.service.impl;

import com.reactor.kafka.exception.UserNotFoundException;
import com.reactor.kafka.model.User;
import com.reactor.kafka.repository.UserRepository;
import com.reactor.kafka.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private KafkaTemplate<String, String> kafkaTemplate;

    public UserServiceImpl(UserRepository userRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.userRepository = userRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${kafka.topicName}")
    private String kafkaTopicName;

    @Override
    public User getUser(String id) {

        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            kafkaTemplate.send(kafkaTopicName, user.get().toString());
            return user.get();
        }
        else
            throw new UserNotFoundException("User not found with id " + id);
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