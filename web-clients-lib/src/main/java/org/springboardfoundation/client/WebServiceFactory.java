package org.springboardfoundation.client;

import org.springboardfoundation.client.need.NeedWebService;
import org.springboardfoundation.client.need.NeedWebServiceImpl;
import org.springboardfoundation.client.user.UserWebService;
import org.springboardfoundation.client.user.UserWebServiceImpl;
import org.springframework.web.client.RestTemplate;

public class WebServiceFactory {

    public static UserWebService createUserWebService(RestTemplate restTemplate, String baseUrl) {
        return new UserWebServiceImpl(restTemplate, baseUrl);
    }

    public static NeedWebService createNeedWebService(RestTemplate restTemplate, String baseUrl) {
        return new NeedWebServiceImpl(restTemplate, baseUrl);
    }
}