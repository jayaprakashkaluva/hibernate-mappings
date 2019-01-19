package com.jp.userservice.controller;

import com.jp.userservice.manager.UserManager;
import com.jp.userservice.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserManager userManager;
    @PostMapping(value = "/user",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public User saveUser(final User user) {
    return userManager.saveUser(user);
    }
}
