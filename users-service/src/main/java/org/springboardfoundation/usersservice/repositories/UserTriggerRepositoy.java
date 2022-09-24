package org.springboardfoundation.usersservice.repositories;

import org.springboardfoundation.usersservice.entity.UserTrigger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTriggerRepositoy extends JpaRepository<UserTrigger,Long> {
}
