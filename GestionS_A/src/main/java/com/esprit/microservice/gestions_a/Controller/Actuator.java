package com.esprit.microservice.gestions_a.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Actuator {

    @GetMapping
    public String hello() {
        return "Hello World";
    }
}
