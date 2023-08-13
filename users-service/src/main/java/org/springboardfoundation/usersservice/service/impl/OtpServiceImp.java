package org.springboardfoundation.usersservice.service.impl;

import org.springboardfoundation.usersservice.dto.OtpDto;
import org.springboardfoundation.usersservice.entity.Otp;
import org.springboardfoundation.usersservice.mapper.OtpMapper;
import org.springboardfoundation.usersservice.mapper.UserMapper;
import org.springboardfoundation.usersservice.service.OtpDbService;
import org.springboardfoundation.usersservice.service.OtpService;
import org.springboardfoundation.usersservice.service.UserDbService;
import org.springboardfoundation.usersservice.utiliy.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtpServiceImp implements OtpService {
    @Autowired
    private OtpDbService otpDbService;

    @Override
    public OtpDto saveOtp(OtpDto otpDto ) {


        // We will call the OTP service and get a unique Id and if we get a unique id , we will mark the status as teue
        //for the frontend to know
        String unique= Utility.generateUUID();
        Otp otp = OtpMapper.MAPPER.map(otpDto, otpDto.getMobileNumber());
        otp.setUniqueId(unique);
        Otp savedotp = otpDbService.save(otp);

        boolean isSuccess = savedotp.getId() > 0 && savedotp.getUniqueId() != null;
        otpDto.setStatus(isSuccess);

        System.out.println("post SAVE otpDto **" + otp);
        // before return copy all data into userdto and return
        return otpDto;
    }

}

