package org.springboardfoundation.usersservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springboardfoundation.usersservice.dto.OtpDto;
import org.springboardfoundation.usersservice.entity.Otp;


@Mapper
public interface OtpMapper {
    OtpMapper MAPPER = Mappers.getMapper(OtpMapper.class);

    OtpDto map(Otp otp);


    @Mapping(source = "mobileNumber", target = "mobileNumber")
    //@Mapping(source = "status", target = "status")
    Otp map(OtpDto otpDto, String mobileNumber);

}
