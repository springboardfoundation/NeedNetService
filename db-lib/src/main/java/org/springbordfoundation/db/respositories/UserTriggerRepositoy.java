package org.springbordfoundation.db.respositories;

import org.springbordfoundation.db.entity.UserTrigger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTriggerRepositoy extends JpaRepository<UserTrigger,Long> {
}