package org.springboardfoundation.dbservice.respositories;

import org.springboardfoundation.dbservice.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OtpRepository extends JpaRepository<Otp, Long> {
    List<Otp> findAllByMobileNumber(String mobileNumber);
}