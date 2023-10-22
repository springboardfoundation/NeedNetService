package org.springboardfoundation.client.user;

import org.springboardfoundation.common.dto.users.UserDto;
import org.springframework.web.client.RestTemplate;

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
        return restTemplate.getForObject(baseUrl + "/" + mobileNumber, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String mobileNumber) {
        restTemplate.put(baseUrl + "/" + mobileNumber, userDto);
        return userDto;
    }
}