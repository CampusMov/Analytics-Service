package com.campusmov.platform.analyticsservice.analytics.interfaces.rest.transform;

import com.campusmov.platform.analyticsservice.analytics.domain.model.aggregates.StudentRatingMetric;
import com.campusmov.platform.analyticsservice.analytics.interfaces.rest.resources.StudentRatingMetricResource;

public class StudentRatingMetricResourceFromEntityAssembler {
    public static StudentRatingMetricResource toResourceFromEntity(StudentRatingMetric studentRatingMetric) {
        return new StudentRatingMetricResource(
                studentRatingMetric.getUserId(),
                studentRatingMetric.getTotalRatings(),
                studentRatingMetric.getTotalReviewsCount(),
                studentRatingMetric.getAverageRating()
        );
    }
}
