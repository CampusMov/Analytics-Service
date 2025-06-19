package com.campusmov.platform.analyticsservice.analytics.infrastructure.brokers.kafka;

import com.campusmov.platform.analyticsservice.analytics.domain.model.events.ProfileCreatedEvent;
import com.campusmov.platform.analyticsservice.analytics.domain.model.events.ValorationCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
public class StudentRatingMetricsEventSource {
    private final ApplicationEventPublisher applicationEventPublisher;

    @Bean
    public Consumer<ValorationCreatedEvent> valorationCreatedEvent() {
        return applicationEventPublisher::publishEvent;
    }

    @Bean
    public Consumer<ProfileCreatedEvent> profileCreatedEvent() {
        return applicationEventPublisher::publishEvent;
    }
}
