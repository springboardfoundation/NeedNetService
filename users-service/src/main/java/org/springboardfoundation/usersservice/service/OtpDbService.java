package org.springboardfoundation.usersservice.service;

import org.springbordfoundation.db.entity.Otp;


public interface OtpDbService {

    Otp save(Otp otp);

    Otp findByMobileNumber(String mobileNumber);
}
