package org.springboardfoundation.usersservice.controller;

import org.springboardfoundation.usersservice.dto.OtpDto;
import org.springboardfoundation.usersservice.service.OtpService;
import org.springboardfoundation.usersservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class OTPController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/getOtp/{mobileNumber}")
    public OtpDto generateOtp(@PathVariable("mobileNumber") String mobileNumber) {
        OtpDto otpDto = new OtpDto();
        otpDto.setMobileNumber(mobileNumber);
        System.out.println("otpDto **" + otpDto);

        return otpService.saveOtp(otpDto);
    }
}
