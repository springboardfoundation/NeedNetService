package org.springboardfoundation.fileservice.web.controller;

import org.springboardfoundation.fileservice.web.ApiConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(ApiConstants.BASE_PATH)
@RequiredArgsConstructor
public class FtcsController {

    @GetMapping("/status")
    public ResponseEntity status() {
        log.info("Health check received.");
        return ResponseEntity.ok("success");
    }
}