package org.springboardfoundation.dbservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springboardfoundation.common.dto.OtpDto;
import org.springboardfoundation.dbservice.entity.Otp;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OtpMapper {
    OtpDto map(Otp otp);

    Otp map(OtpDto otpDto);

}