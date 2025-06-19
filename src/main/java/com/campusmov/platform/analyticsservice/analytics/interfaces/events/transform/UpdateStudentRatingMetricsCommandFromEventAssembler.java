package com.campusmov.platform.analyticsservice.analytics.interfaces.events.transform;

import com.campusmov.platform.analyticsservice.analytics.domain.model.commands.UpdateStudentRatingMetricsCommand;
import com.campusmov.platform.analyticsservice.analytics.domain.model.events.ValorationCreatedEvent;

public class UpdateStudentRatingMetricsCommandFromEventAssembler {
    public static UpdateStudentRatingMetricsCommand toCommandFromEvent(ValorationCreatedEvent event){
        return new UpdateStudentRatingMetricsCommand(event.getUserId(), event.getReputationScore());
    }
}
