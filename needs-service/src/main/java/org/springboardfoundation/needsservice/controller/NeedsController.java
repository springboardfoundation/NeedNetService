package org.springboardfoundation.needsservice.controller;


import org.springboardfoundation.common.dto.users.UserDto;
import org.springboardfoundation.needsservice.service.NeedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/need")
public class NeedsController {
    @Autowired
    private NeedsService needsService;

    @PostMapping("/create/{userId}")
    public UserDto saveinfo(@RequestBody UserDto userDto, @PathVariable("userId") String userId) {
        return null;
    }
}