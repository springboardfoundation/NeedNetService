package org.springboardfoundation.usersservice.repositories;

import org.springboardfoundation.usersservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepositoy extends JpaRepository<User,Long> {
}
