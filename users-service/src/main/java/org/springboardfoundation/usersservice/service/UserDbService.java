package org.springboardfoundation.usersservice.service;

import org.springboardfoundation.usersservice.dto.UserDto;
import org.springboardfoundation.usersservice.entity.User;

public interface UserDbService {

    void save(User user);

    void update(User user);

    User findByUserIdentifier(String userIdentifier);

}
