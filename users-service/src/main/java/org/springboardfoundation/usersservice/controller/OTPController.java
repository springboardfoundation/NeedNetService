package org.springboardfoundation.usersservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboardfoundation.common.dto.OtpDto;
import org.springboardfoundation.usersservice.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class OTPController {

    @Autowired
    private OtpService otpService;
    Logger logger = LoggerFactory.getLogger(LoggingController.class);
    @PostMapping("/getOtp/{mobileNumber}")
    public OtpDto generateOtp(@PathVariable("mobileNumber") String mobileNumber) {
        OtpDto otpDto = new OtpDto();
        otpDto.setMobileNumber(mobileNumber);
        logger.info("otpDto **" + otpDto);
        return otpService.saveOtp(otpDto);
    }

    @PostMapping("/validate/{mobileNumber}/{otp}")
    public OtpDto generateOtp(@PathVariable("mobileNumber") String mobileNumber, @PathVariable("otp") String otp) {
        OtpDto otpDto = new OtpDto();
        otpDto.setMobileNumber(mobileNumber);
        logger.info("otpDto **" + otpDto);

        return otpService.validateOtp(otpDto);
    }
}