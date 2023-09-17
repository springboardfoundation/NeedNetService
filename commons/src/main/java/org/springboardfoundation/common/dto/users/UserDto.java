package org.springboardfoundation.common.dto.users;

import org.springboardfoundation.common.entity.Gender;

import lombok.Data;

@Data
public class UserDto {
    private int userNumber;
    private String name;
    private String email;
    private String place;
    private int age;
    private Gender gender;
    private String occupation;
    private String mobileNumber;
}