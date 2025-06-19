package com.campusmov.platform.analyticsservice.analytics.domain.model.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ValorationCreatedEvent extends ApplicationEvent implements DomainEvent {

    private final String valorationId;
    private final String userId;
    private final String senderId;
    private final Double reputationScore;
    private final String message;


    public ValorationCreatedEvent(Object source, String valorationId, String userId, String senderId,Double reputationScore, String message) {
        super(source);
        this.valorationId = valorationId;
        this.userId = userId;
        this.senderId = senderId;
        this.reputationScore = reputationScore;
        this.message = message;

    }

}
