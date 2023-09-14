package org.springbordfoundation.db.respositories;

import org.springbordfoundation.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoy extends JpaRepository<User, Long> {

    User findByUserIdentifier(String userIdentifier);
}