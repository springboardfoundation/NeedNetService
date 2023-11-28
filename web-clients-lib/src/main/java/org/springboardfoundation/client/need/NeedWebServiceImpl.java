package org.springboardfoundation.client.need;

import lombok.extern.slf4j.Slf4j;
import org.springboardfoundation.common.dto.need.NeedDto;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class NeedWebServiceImpl implements NeedWebService {
    private final RestTemplate restTemplate;
    private final String baseUrl;

    public NeedWebServiceImpl(RestTemplate restTemplate, String baseUrl) {
        this.baseUrl = baseUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public NeedDto saveNeed(NeedDto needDto, String userId) {
        return restTemplate
            .postForObject(baseUrl + "/" + userId, needDto, NeedDto.class);
    }

    @Override
    public NeedDto getNeed(String needId) {
        return restTemplate.getForObject(baseUrl + "/" + needId, NeedDto.class);
    }

    @Override
    public NeedDto updateNeed(NeedDto needDto, String userId) {
        restTemplate.put(baseUrl + "/" + userId, needDto);
        return needDto;
    }
}