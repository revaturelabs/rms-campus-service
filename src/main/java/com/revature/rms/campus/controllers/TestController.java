package com.revature.rms.campus.controllers;

import com.revature.rms.campus.entities.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/test")
public class TestController {

    /**
     * Simple test for a controller
     * @return User object
     */
    @GetMapping(value = "/user",produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser() {
        User test = new User(1,"Juan","Valencia");
        return test;
    }

}
