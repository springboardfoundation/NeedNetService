package org.springboardfoundation.usersservice.service;

import org.springboardfoundation.common.dto.users.UserDto;

public interface UserService {

    UserDto saveUser(UserDto userDto, String mobileNumber);

    UserDto checkUserIdentifier(String userIdentifier);

    UserDto updateUserInfo(UserDto userDto,String userIdentifier);


}