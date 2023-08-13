package org.springboardfoundation.usersservice.controller;


import org.springboardfoundation.common.dto.UserDto;
import org.springboardfoundation.usersservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserRegistrationController {
    @Autowired
    private UserService userService;

    @PostMapping("/register/{mobileNumber}")
    public UserDto saveinfo(@RequestBody UserDto userDto, @PathVariable("mobileNumber") String mobileNumber) {
        //userDto.setMobileNumber(Integer.parseInt(mobileNumber));

        return userService.saveUser(userDto, mobileNumber);
    }
    @GetMapping
    public ResponseEntity<UserDto> getUser(@RequestParam(name="searchKey")String searchKey,
                                           @RequestParam(name="searchParam")String userIdentifier) {
        try {
            if(searchKey.equalsIgnoreCase("userIdentifier"))
                return ResponseEntity.ok().body(userService.checkUserIdentifier(userIdentifier));
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/register/{userIdentifier}")
    public UserDto updateInfo(@RequestBody UserDto userDto,@PathVariable("userIdentifier") String userIdentifier){
        return userService.updateUserInfo(userDto,userIdentifier);
    }
}