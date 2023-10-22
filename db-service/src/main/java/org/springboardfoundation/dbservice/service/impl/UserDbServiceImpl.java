package org.springboardfoundation.dbservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springboardfoundation.common.dto.users.UserDto;
import org.springboardfoundation.dbservice.mapper.UserMapper;
import org.springboardfoundation.dbservice.respositories.UserRepository;
import org.springboardfoundation.dbservice.service.UserDbService;
import org.springboardfoundation.dbservice.entity.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDbServiceImpl implements UserDbService {

    private final UserMapper mapper;
    private final UserRepository userRepository;

    @Override
    public UserDto getUserByMobileNumber(String mobileNumber) {
        return userRepository.findByMobileNumber(mobileNumber)
            .map(mapper::map)
            .orElseThrow();
    }

    @Override
    public UserDto getUserByIdentifier(String userIdentifier) {
        return userRepository.findByUserIdentifier(userIdentifier)
            .map(mapper::map)
            .orElseThrow();
    }

    @Override
    public UserDto saveUser(UserDto userDto, String mobileNumber) {
        return mapper.map(
            userRepository.save(mapper.map(userDto, mobileNumber))
        );
    }

    @Override
    public UserDto updateUser(UserDto userDto, String mobileNumber) {
        User user = userRepository.findByMobileNumber(mobileNumber).orElseThrow();
        user = userRepository.save(mapper.map(user, userDto));
        return mapper.map(user);
    }

    @Override
    public UserDto deleteUser(String mobileNumber) {
        User user = userRepository.findByMobileNumber(mobileNumber).orElseThrow();
        userRepository.delete(user);
        return mapper.map(user);
    }
}