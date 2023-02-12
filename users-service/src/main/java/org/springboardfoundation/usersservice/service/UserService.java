package org.springboardfoundation.usersservice.service;

import org.springboardfoundation.usersservice.dto.UserDto;

public interface UserService {

    UserDto saveUser(UserDto userDto, String mobileNumber);

    UserDto checkUserIdentifier(String userIdentifier);

    UserDto updateUserInfo(UserDto userDto,String userIdentifier);


}
