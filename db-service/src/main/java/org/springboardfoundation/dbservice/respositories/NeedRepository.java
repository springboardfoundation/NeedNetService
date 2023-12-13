package org.springboardfoundation.dbservice.respositories;

import org.springboardfoundation.dbservice.entity.Need;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeedRepository extends JpaRepository<Need, Long> {
}