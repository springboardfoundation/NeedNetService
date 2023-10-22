package org.springboardfoundation.usersservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springboardfoundation.client.user.UserWebService;
import org.springboardfoundation.common.dto.users.UserDto;
import org.springboardfoundation.common.utiliy.Utility;
import org.springboardfoundation.usersservice.mapper.UserMapper;
import org.springboardfoundation.usersservice.service.UserService;
import org.springbordfoundation.db.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    // @Autowired
    // private UserDbService userDbService;
    private final UserWebService userWebService;

    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDto saveUser(UserDto userDto, String mobileNumber) {
        // copy all data into new user object pass that to save
         User user = UserMapper.MAPPER.map(userDto, mobileNumber);
        //User user = UserMapper.MAPPER.map(mobileNumber);
        // String x = Utility.generateUUID();
        //user.setUserIdentifier(x);
        //user.setPassword(passwordEncoder.encode(user.getPassword()));+
        userDto.setUserIdentifier(Utility.generateUUID());
        userDto = userWebService.saveUser(userDto, mobileNumber);
        userDto.setUserIdentifier(null);
        // userDbService.save(user);
        // before return copy all data into userdto and return
        return userDto;
    }

    @Override
    public UserDto checkUserIdentifier(String userIdentifier) {
        // User user = userDbService.findByUserIdentifier(userIdentifier);
        User user = new User();
        return UserMapper.MAPPER.map(user);
    }

    @Override
    public UserDto updateUserInfo(UserDto userDto, String userIdentifier) {
        User user = new User();
        // User user = userDbService.findByUserIdentifier(userIdentifier);
        user.setName(userDto.getName());
        user.setMobileNumber(userDto.getMobileNumber());
        // userDbService.update(user);
        return UserMapper.MAPPER.map(user);
    }
}