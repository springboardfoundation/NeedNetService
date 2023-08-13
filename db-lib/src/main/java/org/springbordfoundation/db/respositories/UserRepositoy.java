package org.springbordfoundation.db.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springbordfoundation.db.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface UserRepositoy extends JpaRepository<User,Long> {

    User findByUserIdentifier(String userIdentifier);
}