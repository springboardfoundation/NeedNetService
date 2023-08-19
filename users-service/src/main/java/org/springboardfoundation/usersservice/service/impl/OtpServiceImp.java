package org.springboardfoundation.usersservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboardfoundation.common.utiliy.Utility;
import org.springboardfoundation.usersservice.controller.LoggingController;
import org.springboardfoundation.usersservice.controller.OTPController;
import org.springboardfoundation.usersservice.dto.OtpDto;
import org.springbordfoundation.db.entity.Otp;
import org.springboardfoundation.usersservice.mapper.OtpMapper;
import org.springbordfoundation.db.service.OtpDbService;
import org.springboardfoundation.usersservice.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OtpServiceImp implements OtpService {
    @Autowired
    private OtpDbService otpDbService;
    Logger logger = LoggerFactory.getLogger(OtpServiceImp.class);

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

//        System.out.println("post SAVE otpDto **" + otp);
        logger.info("post SAVE otpDto **" + otp);
        // before return copy all data into userdto and return
        return otpDto;
    }

    @Override
    public OtpDto validateOtp(OtpDto otpDto ) {

//        Otp otp = OtpMapper.MAPPER.map(otpDto, otpDto.getMobileNumber());

        // Validate with the service using the unique key
        List<Otp> otp = otpDbService.findAllByMobileNumber(otpDto.getMobileNumber());
   
        otpDto.setStatus(otp != null);

        System.out.println("Fetched  OTP **" + otp);

        // before return copy all data into userdto and return
        return otpDto;
    }


}

