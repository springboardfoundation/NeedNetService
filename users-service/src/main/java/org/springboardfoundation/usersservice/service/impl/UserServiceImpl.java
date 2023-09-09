package org.springboardfoundation.usersservice.service.impl;

import org.springboardfoundation.common.dto.UserDto;
import org.springboardfoundation.usersservice.mapper.UserMapper;
import org.springboardfoundation.usersservice.service.UserService;
import org.springboardfoundation.common.utiliy.Utility;
import org.springbordfoundation.db.entity.User;
import org.springbordfoundation.db.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<User> user = userDbService.findByUserIdentifier(userIdentifier);
        return user.map(UserMapper.MAPPER::map).orElse(null);
    }

    @Override
    public UserDto updateUserInfo(UserDto userDto, String userIdentifier) {

        Optional<User> userOptional = userDbService.findByUserIdentifier(userIdentifier);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(userDto.getName());
            user.setMobileNumber(userDto.getMobileNumber());
            userDbService.update( user);
            return UserMapper.MAPPER.map(user);
        }

        return null;
    }
}