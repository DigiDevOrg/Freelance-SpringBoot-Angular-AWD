package com.example.microservice_categories_skills;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroServiceCategoriesSkillsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCategoriesSkillsApplication.class, args);
    }

}
