package org.springbordfoundation.db.respositories;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springbordfoundation.db.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
@Repository
public interface UserRepositoy extends JpaRepository<User,Long> {

    Optional<User> findByUserIdentifier(String userIdentifier);

    Optional<User> findByMobileNumber(String phoneNumber);
}