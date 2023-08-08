package org.springboardfoundation.common.dto;

import lombok.Data;
import org.springboardfoundation.common.entity.Gender;
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