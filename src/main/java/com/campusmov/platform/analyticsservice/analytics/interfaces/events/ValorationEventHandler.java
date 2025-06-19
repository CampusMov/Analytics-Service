package com.campusmov.platform.analyticsservice.analytics.interfaces.events;

import com.campusmov.platform.analyticsservice.analytics.domain.model.events.ValorationCreatedEvent;
import com.campusmov.platform.analyticsservice.analytics.domain.service.StudentRatingMetricCommandService;
import com.campusmov.platform.analyticsservice.analytics.interfaces.events.transform.UpdateStudentRatingMetricsCommandFromEventAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValorationEventHandler {
    private final StudentRatingMetricCommandService studentRatingMetricCommandService;

    @EventListener
    public void handleValorationCreatedEvent(ValorationCreatedEvent event){
        var updateStudentRatingMetricsCommand = UpdateStudentRatingMetricsCommandFromEventAssembler.toCommandFromEvent(event);
        studentRatingMetricCommandService.handle(updateStudentRatingMetricsCommand);
    }
}
