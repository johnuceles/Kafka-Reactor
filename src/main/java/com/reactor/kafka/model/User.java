package com.reactor.kafka.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {

    @Id
    public String id;

    public String firstName;

    public String lastName;

    public Integer age;

    public Integer phone;

    public String email;

    public Address address;
}
