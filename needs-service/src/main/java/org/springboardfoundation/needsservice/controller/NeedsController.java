package org.springboardfoundation.needsservice.controller;


import org.apache.commons.lang.StringUtils;
import org.springboardfoundation.common.dto.need.NeedDto;
import org.springboardfoundation.common.dto.need.NeedStatus;
import org.springboardfoundation.common.utiliy.Utility;
import org.springboardfoundation.common.web.BaseController;
import org.springboardfoundation.needsservice.service.NeedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/need")
public class NeedsController extends BaseController {
    @Autowired
    private NeedsService needsService;

    @PostMapping("/create/{userId}")
    public ResponseEntity<NeedDto> createNeed(@RequestHeader(value = "operationId", required = false) String operationId,
                                              @RequestBody NeedDto need, @PathVariable("userId") String userId) {
        if (StringUtils.isEmpty(operationId)) operationId = Utility.generateUUID();
        return ok(needsService.create(need, userId), operationId);
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<NeedDto>> getUserNeeds(@RequestHeader(value = "operationId", required = false) String operationId,
                                                      @PathVariable("userId") String userId, @RequestParam("pageStart") int pageStart,
                                                      @RequestParam("pageSize") int pageSize) {
        if (StringUtils.isEmpty(operationId)) operationId = Utility.generateUUID();
        return ok(needsService.getUserNeedIds(userId, pageStart, pageSize), operationId);
    }

    @GetMapping("/ids/{userId}")
    public ResponseEntity<List<String>> getNeedIds(@RequestHeader(value = "operationId", required = false) String operationId,
                                                   @PathVariable("userId") String userId,
                                                   @RequestParam(value = "status", defaultValue = "published") NeedStatus status) {
        if (StringUtils.isEmpty(operationId)) operationId = Utility.generateUUID();
        return ok(needsService.getUserNeedIds(userId, status), operationId);
    }

    @GetMapping("/{needId}")
    public ResponseEntity<NeedDto> getNeed(@RequestHeader(value = "operationId", required = false) String operationId,
                                           @PathVariable("needId") String needId) {
        if (StringUtils.isEmpty(operationId)) operationId = Utility.generateUUID();
        return ok(needsService.getNeed(needId), operationId);
    }

    @PutMapping("/publish/{needId}")
    public ResponseEntity<NeedDto> publishNeed(@RequestHeader(value = "operationId", required = false) String operationId,
                                               @RequestBody NeedDto need, @PathVariable("needId") String needId) {
        if (StringUtils.isEmpty(operationId)) operationId = Utility.generateUUID();
        return ok(needsService.publish(needId), operationId);
    }
}