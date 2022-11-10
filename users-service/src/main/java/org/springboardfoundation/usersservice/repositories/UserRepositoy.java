package org.springboardfoundation.usersservice.repositories;

import org.springboardfoundation.usersservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  UserRepositoy extends JpaRepository<User,Long> {

    User findByUserIdentifier(String userIdentifier);

}
