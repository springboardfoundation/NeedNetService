package org.springboardfoundation.usersservice.controller;


import org.springboardfoundation.usersservice.dto.UserDto;
import org.springboardfoundation.usersservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserRegistrationController {
    @Autowired
    private UserService userService;
    @PostMapping("/register/{mobileNumber}")
    public UserDto saveinfo(@RequestBody UserDto userDto,@PathVariable("mobileNumber") String mobileNumber) {
        //userDto.setMobileNumber(Integer.parseInt(mobileNumber));

        return userService.saveUser(userDto,mobileNumber);
    }
}
