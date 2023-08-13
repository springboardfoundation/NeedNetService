package org.springboardfoundation.usersservice.service.impl;

import org.springboardfoundation.common.dto.UserDto;
import org.springboardfoundation.usersservice.mapper.UserMapper;
import org.springboardfoundation.usersservice.service.UserService;
import org.springboardfoundation.common.utiliy.Utility;
import org.springbordfoundation.db.entity.User;
import org.springbordfoundation.db.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDbService userDbService;

    @Override
    public UserDto saveUser(UserDto userDto, String mobileNumber) {
        // copy all data into new user object pass that to save
        User user = UserMapper.MAPPER.map(userDto, mobileNumber);
        //User user = UserMapper.MAPPER.map(mobileNumber);
        String x = Utility.generateUUID();
        user.setUserIdentifier(x);
        userDbService.save(user);
        // before return copy all data into userdto and return
        return UserMapper.MAPPER.map(user);
    }

    @Override
    public UserDto checkUserIdentifier(String userIdentifier) {
        User user = userDbService.findByUserIdentifier(userIdentifier);
        return UserMapper.MAPPER.map(user);
    }

    @Override
    public UserDto updateUserInfo(UserDto userDto, String userIdentifier) {

        User user = userDbService.findByUserIdentifier(userIdentifier);
        user.setName(userDto.getName());
        user.setMobileNumber(userDto.getMobileNumber());
        userDbService.update(user);
        return UserMapper.MAPPER.map(user);
    }
}