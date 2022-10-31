package org.springboardfoundation.usersservice.dto;

import lombok.Data;
@Data
public class UserDto {
    private int userNumber;
    private String name;
    private String email;
    private String place;
    private int age;
    private String gender;
    private String occupation;
    private String mobileNumber;
}
