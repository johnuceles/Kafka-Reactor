package com.reactor.kafka.model;

import lombok.Data;

@Data
public class Address {

    public String address_line_1;

    public String address_line_2;

    public String city;

    public String state;

    public Integer zip;
}
