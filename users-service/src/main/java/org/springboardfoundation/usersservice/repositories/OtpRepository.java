package org.springboardfoundation.usersservice.repositories;

import org.springboardfoundation.usersservice.entity.Otp;
import org.springboardfoundation.usersservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepository extends JpaRepository<Otp,Long> {
    Otp save(Otp otp);
}