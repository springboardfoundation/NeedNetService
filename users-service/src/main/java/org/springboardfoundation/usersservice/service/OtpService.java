package org.springboardfoundation.usersservice.service;

import org.springboardfoundation.common.dto.OtpDto;


public interface OtpService {
    OtpDto saveOtp(OtpDto otpdto);

    OtpDto validateOtp(OtpDto otpdto);
}