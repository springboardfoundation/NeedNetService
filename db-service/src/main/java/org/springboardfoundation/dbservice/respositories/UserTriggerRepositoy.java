package org.springboardfoundation.dbservice.respositories;

import org.springboardfoundation.dbservice.entity.UserTrigger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTriggerRepositoy extends JpaRepository<UserTrigger,Long> {
}