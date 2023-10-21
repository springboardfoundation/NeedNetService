package org.springboardfoundation.common.dto;

import lombok.Data;

@Data
public class OtpDto {
    private String mobileNumber;
    private boolean status;
    private String otp;
}