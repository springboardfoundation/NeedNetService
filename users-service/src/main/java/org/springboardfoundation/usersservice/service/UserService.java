package org.springboardfoundation.usersservice.service;

import org.springboardfoundation.usersservice.dto.UserDto;

public interface UserService {

    UserDto saveUser(UserDto userDto, String mobileNumber);
}
