package org.springboardfoundation.usersservice.dto;

import lombok.Data;

@Data
public class OtpDto {
    private String mobileNumber;
    private boolean status;
}
