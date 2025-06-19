package com.campusmov.platform.analyticsservice.analytics.domain.service;

import com.campusmov.platform.analyticsservice.analytics.domain.model.aggregates.StudentRatingMetric;
import com.campusmov.platform.analyticsservice.analytics.domain.model.queries.GetStudentRatingMetricQuery;

import java.util.Optional;

public interface StudentRatingMetricQueryService {

    Optional<StudentRatingMetric> handle(GetStudentRatingMetricQuery query);

}
