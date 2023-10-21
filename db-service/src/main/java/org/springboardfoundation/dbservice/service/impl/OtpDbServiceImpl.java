package org.springboardfoundation.dbservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springboardfoundation.common.dto.OtpDto;
import org.springboardfoundation.dbservice.mapper.OtpMapper;
import org.springboardfoundation.dbservice.respositories.OtpRepository;
import org.springboardfoundation.dbservice.service.OtpDbService;
import org.springboardfoundation.dbservice.entity.Otp;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OtpDbServiceImpl implements OtpDbService {
    private final OtpMapper mapper;
    private final OtpRepository otpRepository;

    @Override
    public OtpDto getOtp(String mobileNumber) {
        return otpRepository.findAllByMobileNumber(mobileNumber)
            .stream().findFirst()
            .map(mapper::map)
            .orElseThrow();
    }

    @Override
    public OtpDto saveOtp(OtpDto otpdto) {
        Otp otp = mapper.map(otpdto);
        otp = otpRepository.save(otp);
        return mapper.map(otp);
    }

    @Override
    public void deleteOtp(String mobileNumber) {
        otpRepository.findAllByMobileNumber(mobileNumber)
            .forEach(otpRepository::delete);
    }
}