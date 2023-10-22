package org.springboardfoundation.dbservice.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springboardfoundation.common.dto.users.UserDto;
import org.springboardfoundation.common.web.BaseController;
import org.springboardfoundation.dbservice.service.UserDbService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springboardfoundation.dbservice.web.ApiConstants.*;

/*
 * Ref: https://spring.io/guides/gs/uploading-files/
 */

@Slf4j
@RestController
@RequestMapping(USER_PATH)
@RequiredArgsConstructor
public class UsersDbController extends BaseController {

    private final UserDbService userDbService;

    @GetMapping(MOBILE_NUMBER_PARAM)
    public ResponseEntity<UserDto> getUserByMobileNumber(@PathVariable(MOBILE_NUMBER_PARAM) String mobileNumber) {
        UserDto userDto = userDbService.getUserByMobileNumber(mobileNumber);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping(USERID_PARAM)
    public ResponseEntity<UserDto> getUserByUserIdentifier(@PathVariable(USERID_PARAM) String userIdentifier) {
        UserDto userDto = userDbService.getUserByIdentifier(userIdentifier);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping(MOBILE_NUMBER_PARAM)
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto, @PathVariable(MOBILE_NUMBER_PARAM) String mobileNumber) {
        userDto = userDbService.saveUser(userDto, mobileNumber);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping(MOBILE_NUMBER_PARAM)
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto, @PathVariable(MOBILE_NUMBER_PARAM) String mobileNumber) {
        userDto = userDbService.updateUser(userDto, mobileNumber);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping(MOBILE_NUMBER_PARAM)
    public ResponseEntity<UserDto> delete(@PathVariable(MOBILE_NUMBER_PARAM) String mobileNumber) {
        UserDto userDto = userDbService.deleteUser(mobileNumber);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/status")
    public ResponseEntity status() {
        log.info("Health check received.");
        return ResponseEntity.ok("success");
    }
}