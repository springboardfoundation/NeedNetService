package org.springboardfoundation.usersservice.service;

import org.springboardfoundation.usersservice.dto.UserDto;
import org.springboardfoundation.usersservice.entity.User;

public interface UserService {

    UserDto saveUser(UserDto userDto);
}
