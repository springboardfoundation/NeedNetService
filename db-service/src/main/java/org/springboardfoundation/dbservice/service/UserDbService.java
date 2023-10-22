package org.springboardfoundation.dbservice.service;

import org.springboardfoundation.common.dto.users.UserDto;

public interface UserDbService {
    UserDto getUserByMobileNumber(String mobileNumber);

    UserDto getUserByIdentifier(String userIdentifier);

    UserDto saveUser(UserDto userDto, String mobileNumber);

    UserDto updateUser(UserDto userDto, String mobileNumber);

    UserDto deleteUser(String mobileNumber);
}