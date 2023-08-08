package org.springbordfoundation.db.service;

import org.springbordfoundation.db.entity.User;

public interface UserDbService {

    void save(User user);

    void update(User user);

    User findByUserIdentifier(String userIdentifier);

}