package org.springboardfoundation.usersservice.controller;


import org.springboardfoundation.usersservice.dto.UserDto;
import org.springboardfoundation.usersservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/register/")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDto saveinfo(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }
}
