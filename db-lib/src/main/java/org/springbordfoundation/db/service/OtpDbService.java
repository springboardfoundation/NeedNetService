package org.springbordfoundation.db.service;

import org.springbordfoundation.db.entity.Otp;

import java.util.List;


public interface OtpDbService {

    Otp save(Otp otp);

    List<Otp> findAllByMobileNumber(String mobileNumber);
}
