package org.springbordfoundation.db.respositories;

import java.util.List;

import org.springbordfoundation.db.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepository extends JpaRepository<Otp, Long> {
    List<Otp> findAllByMobileNumber(String mobileNumber);
}