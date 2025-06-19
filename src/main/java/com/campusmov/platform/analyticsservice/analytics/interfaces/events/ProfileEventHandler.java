package com.campusmov.platform.analyticsservice.analytics.interfaces.events;

import com.campusmov.platform.analyticsservice.analytics.domain.model.events.ProfileCreatedEvent;
import com.campusmov.platform.analyticsservice.analytics.domain.service.StudentRatingMetricCommandService;
import com.campusmov.platform.analyticsservice.analytics.interfaces.events.transform.CreateStudentRatingMetricsCommandFromEventAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileEventHandler {
    private final StudentRatingMetricCommandService studentRatingMetricCommandService;

    @EventListener
    public void handleProfileCreatedEvent(ProfileCreatedEvent event) {
        var createStudentRatingMetricsCommand = CreateStudentRatingMetricsCommandFromEventAssembler.toCommandFromEvent(event);
        studentRatingMetricCommandService.handle(createStudentRatingMetricsCommand);
    }
}
