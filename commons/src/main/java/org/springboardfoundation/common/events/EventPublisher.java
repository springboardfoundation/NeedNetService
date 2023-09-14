package org.springboardfoundation.common.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public EventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(final FileUploadEvent fileUploadEvent) {
        log.info("Publishing event: " + fileUploadEvent);
        applicationEventPublisher.publishEvent(fileUploadEvent);
    }

}
