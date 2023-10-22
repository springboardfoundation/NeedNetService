package org.springboardfoundation.client;

import org.springboardfoundation.client.user.UserWebService;
import org.springboardfoundation.client.user.UserWebServiceImpl;
import org.springframework.web.client.RestTemplate;

public class WebServiceFactory {

    public static UserWebService createUserWebService(RestTemplate restTemplate, String baseUrl) {
        return new UserWebServiceImpl(restTemplate, baseUrl);
    }
}