package org.springbordfoundation.db.respositories;

import org.springbordfoundation.db.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
@Repository
public interface OtpRepository extends JpaRepository<Otp,Long> {
    Otp save(Otp otp);
}