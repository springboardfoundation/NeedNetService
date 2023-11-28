package org.springboardfoundation.client.user;

import org.springboardfoundation.common.dto.users.UserDto;

public interface UserWebService {
    UserDto getUser(String mobileNumber);
    UserDto getUserById(String userId);

    UserDto saveUser(UserDto userDto, String mobileNumber);

    UserDto updateUser(UserDto userDto, String mobileNumber);
}