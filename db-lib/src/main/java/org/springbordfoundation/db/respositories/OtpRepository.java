package org.springbordfoundation.db.respositories;

import org.springbordfoundation.db.entity.Otp;
import org.springbordfoundation.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
@Repository
public interface OtpRepository extends JpaRepository<Otp,Long> {
    //Generate OTP
    //Otp save(Otp otp);
    Otp findByMobileNumber(String mobileNumber);
}