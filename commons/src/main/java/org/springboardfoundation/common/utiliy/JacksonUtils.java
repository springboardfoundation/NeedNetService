package org.springboardfoundation.common.utiliy;


import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.databind.DeserializationFeature.*;
import static com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

public class JacksonUtils {

    public static ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(NON_NULL);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(WRITE_DATES_AS_TIMESTAMPS, true);
        objectMapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(FAIL_ON_NULL_FOR_PRIMITIVES, false);
        objectMapper.configure(FAIL_ON_NUMBERS_FOR_ENUMS, false);
        objectMapper.configure(FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        objectMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        objectMapper.enable(MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING);
        return objectMapper;
    }

}
