package org.springboardfoundation.dbservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springboardfoundation.common.web.BaseController;
import org.springboardfoundation.common.web.ApiConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(ApiConstants.NEED_PATH)
@RequiredArgsConstructor
public class NeedsDbController extends BaseController {

    @GetMapping("/status")
    public ResponseEntity status() {
        log.info("Health check received.");
        return ResponseEntity.ok("success");
    }
}