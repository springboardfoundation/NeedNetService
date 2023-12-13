package org.springboardfoundation.dbservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springboardfoundation.common.dto.need.NeedDto;
import org.springboardfoundation.common.web.ApiConstants;
import org.springboardfoundation.common.web.BaseController;
import org.springboardfoundation.dbservice.service.NeedDbService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springboardfoundation.common.web.ApiConstants.USERID;
import static org.springboardfoundation.common.web.ApiConstants.USERID_PARAM;

@Slf4j
@RestController
@RequestMapping(ApiConstants.NEED_PATH)
@RequiredArgsConstructor
public class NeedDbController extends BaseController {

    private final NeedDbService needDbService;

    @PostMapping(USERID_PARAM)
    public ResponseEntity<NeedDto> save(@RequestBody NeedDto needDto, @PathVariable(USERID) String userIdentifier) {
        return ResponseEntity.ok(needDbService.saveNeed(needDto, userIdentifier));
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        log.info("NeedDbController: Health check received.");
        return ResponseEntity.ok("success");
    }


}