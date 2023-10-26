package com.esprit.microservice.gestions_a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GestionSAApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionSAApplication.class, args);
    }

}
