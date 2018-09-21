package com.reactor.kafka.controller;

import com.reactor.kafka.model.User;
import com.reactor.kafka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(params = "id")
    public User getUser(@RequestParam("id") String id) {

        return userService.getUser(id);
    }

    @GetMapping(params = "firstName")
    public List<User> getUsersByFirstName(@RequestParam("firstName") String firstName) {

        return userService.getUsersByFirstName(firstName);
    }

    @GetMapping(params = "lastName")
    public List<User> getUsersByLastName(@RequestParam("lastName") String lastName) {

        return userService.getUsersByLastName(lastName);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("/all/paginate")
    public List<User> getAllUsersPaginated(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) {

        return userService.getAllUsersPaginated(pageNumber, pageSize);
    }
}