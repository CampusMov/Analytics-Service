package com.campusmov.platform.analyticsservice.analytics.interfaces.events.transform;

import com.campusmov.platform.analyticsservice.analytics.domain.model.commands.CreateStudentRatingMetricsCommand;
import com.campusmov.platform.analyticsservice.analytics.domain.model.events.ProfileCreatedEvent;

public class CreateStudentRatingMetricsCommandFromEventAssembler {
    public static CreateStudentRatingMetricsCommand toCommandFromEvent(ProfileCreatedEvent event){
        return new CreateStudentRatingMetricsCommand(event.getProfileId());
    }
}
