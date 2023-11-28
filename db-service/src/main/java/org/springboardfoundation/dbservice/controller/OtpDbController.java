package org.springboardfoundation.dbservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springboardfoundation.common.dto.OtpDto;
import org.springboardfoundation.common.web.BaseController;
import org.springboardfoundation.dbservice.service.OtpDbService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springboardfoundation.common.web.ApiConstants.MOBILE_NUMBER_PARAM;
import static org.springboardfoundation.common.web.ApiConstants.OTP_PATH;

@Slf4j
@RestController
@RequestMapping(OTP_PATH)
@RequiredArgsConstructor
public class OtpDbController extends BaseController {

    private final OtpDbService otpDbService;

    @PostMapping
    public ResponseEntity<OtpDto> save(@RequestBody OtpDto otpDto) {
        otpDto = otpDbService.saveOtp(otpDto);
        return ResponseEntity.ok(otpDto);
    }

    @GetMapping(MOBILE_NUMBER_PARAM)
    public ResponseEntity<OtpDto> findOtp(@PathVariable String mobileNumber) {
        return ResponseEntity.ok(otpDbService.getOtp(mobileNumber));
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        log.info("OtpDbController: Health check received.");
        return ResponseEntity.ok("success");
    }
}