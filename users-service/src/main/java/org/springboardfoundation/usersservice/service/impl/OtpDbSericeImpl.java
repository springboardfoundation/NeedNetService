package org.springboardfoundation.usersservice.service.impl;

import org.springbordfoundation.db.entity.Otp;
import org.springbordfoundation.db.respositories.OtpRepository;
import org.springboardfoundation.usersservice.service.OtpDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtpDbSericeImpl implements OtpDbService {

    @Autowired
    private OtpRepository otpRepository;
    @Override
    public Otp save(Otp otp) {
        return otpRepository.save(otp);
    }

    @Override
    public Otp findByMobileNumber(String mobileNumber) {
        return otpRepository.findByMobileNumber(mobileNumber);
    }
}
