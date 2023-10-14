package org.springbordfoundation.db.service;

import org.springbordfoundation.db.entity.User;

import java.util.Optional;

public interface UserDbService {

    void save(User user);

    void update(User user);

    Optional<User> findByUserIdentifier(String userIdentifier);

}