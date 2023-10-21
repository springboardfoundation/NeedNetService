package org.springboardfoundation.dbservice.service;

import org.springboardfoundation.common.dto.OtpDto;


public interface OtpDbService {
    OtpDto getOtp(String otpId);

    OtpDto saveOtp(OtpDto otpdto);

    void deleteOtp(String otpId);
}