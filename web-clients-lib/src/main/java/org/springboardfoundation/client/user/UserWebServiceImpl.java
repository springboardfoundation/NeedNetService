package org.springboardfoundation.client.user;

import org.springboardfoundation.common.dto.users.UserDto;
import org.springframework.web.client.RestTemplate;

import static org.springboardfoundation.common.web.ApiConstants.*;

public class UserWebServiceImpl implements UserWebService {
    private final RestTemplate restTemplate;
    private final String baseUrl;

    public UserWebServiceImpl(RestTemplate restTemplate, String baseUrl) {
        this.baseUrl = baseUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public UserDto saveUser(UserDto userDto, String mobileNumber) {
        return restTemplate.postForObject(baseUrl + "/" + mobileNumber, userDto, UserDto.class);
    }

    @Override
    public UserDto getUser(String mobileNumber) {
        return restTemplate.getForObject(baseUrl + BY_MOBILE_NUMBER + "/" + MOBILE_NUMBER_PARAM, UserDto.class, mobileNumber);
    }

    @Override
    public UserDto getUserById(String userId) {
        return restTemplate.getForObject(baseUrl + BY_USERID + "/" + USERID_PARAM, UserDto.class, userId);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String mobileNumber) {
        restTemplate.put(baseUrl + "/" + mobileNumber, userDto);
        return userDto;
    }
}