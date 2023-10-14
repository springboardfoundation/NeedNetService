package org.springbordfoundation.db.service.impl;

import org.springbordfoundation.db.respositories.UserRepository;
import org.springbordfoundation.db.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springbordfoundation.db.entity.User;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDbServiceImpl implements UserDbService {

    @Autowired
    private UserRepository userRepositoy;

    @Override
    public void save(User user) {
        userRepositoy.save(user);
    }

    @Override
    public void update(User user) {
        userRepositoy.save(user);
    }

    @Override
    public Optional<User> findByUserIdentifier(String userIdentifier) {
        return userRepositoy.findByUserIdentifier(userIdentifier);
    }
}