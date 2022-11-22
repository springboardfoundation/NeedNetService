package org.springboardfoundation.usersservice.service.impl;

import org.springboardfoundation.usersservice.entity.User;
import org.springboardfoundation.usersservice.repositories.UserRepositoy;
import org.springboardfoundation.usersservice.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDbServiceImpl implements UserDbService {

    @Autowired
    private UserRepositoy userRepositoy;

    @Override
    public void save(User user) {
        userRepositoy.save(user);
    }

    @Override
    public User findByUserIdentifier(String userIdentifier) {
        return userRepositoy.findByUserIdentifier(userIdentifier);
    }
}
