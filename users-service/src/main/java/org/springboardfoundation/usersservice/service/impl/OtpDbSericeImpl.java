package org.springboardfoundation.usersservice.service.impl;

import org.springboardfoundation.usersservice.entity.Otp;
import org.springboardfoundation.usersservice.repositories.OtpRepository;
import org.springboardfoundation.usersservice.repositories.UserRepositoy;
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
}
