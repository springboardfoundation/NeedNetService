package org.springbordfoundation.db.service.impl;

import org.springbordfoundation.db.entity.Otp;
import org.springbordfoundation.db.respositories.OtpRepository;
import org.springbordfoundation.db.service.OtpDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtpDbSericeImpl implements OtpDbService {

    @Autowired
    private OtpRepository otpRepository;
    @Override
    public Otp save(Otp otp) {
        return otpRepository.save(otp);
    }

    @Override
    public List<Otp> findAllByMobileNumber(String mobileNumber) {
        return otpRepository.findAllByMobileNumber(mobileNumber);
    }
}
