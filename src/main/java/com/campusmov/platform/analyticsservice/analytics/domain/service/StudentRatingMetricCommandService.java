package com.campusmov.platform.analyticsservice.analytics.domain.service;

import com.campusmov.platform.analyticsservice.analytics.domain.model.commands.CreateStudentRatingMetricsCommand;
import com.campusmov.platform.analyticsservice.analytics.domain.model.commands.UpdateStudentRatingMetricsCommand;

public interface StudentRatingMetricCommandService {
    void handle(UpdateStudentRatingMetricsCommand command);
    void handle(CreateStudentRatingMetricsCommand command);
}
