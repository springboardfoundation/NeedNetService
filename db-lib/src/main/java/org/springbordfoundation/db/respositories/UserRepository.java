package org.springbordfoundation.db.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springbordfoundation.db.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserIdentifier(String userIdentifier);

    Optional<User> findByMobileNumber(String phoneNumber);
}