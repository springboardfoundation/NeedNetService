package org.springbordfoundation.db.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springboardfoundation.usersservice.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoy extends JpaRepository<User,Long> {

    User findByUserIdentifier(String userIdentifier);
}
