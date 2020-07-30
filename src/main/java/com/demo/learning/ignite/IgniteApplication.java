package com.demo.learning.ignite;

import org.apache.ignite.springdata22.repository.config.EnableIgniteRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableIgniteRepositories
public class IgniteApplication {

    public static void main(String[] args) {
        SpringApplication.run(IgniteApplication.class, args);
    }

}
