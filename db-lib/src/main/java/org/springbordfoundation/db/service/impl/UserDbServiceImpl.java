package org.springbordfoundation.db.service.impl;

import org.springbordfoundation.db.respositories.UserRepositoy;
import org.springbordfoundation.db.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springboardfoundation.usersservice.entity.User;

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
