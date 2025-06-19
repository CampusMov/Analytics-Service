package com.campusmov.platform.analyticsservice.analytics.domain.model.queries;

public record GetStudentRatingMetricQuery(String userId) {

    public GetStudentRatingMetricQuery {
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("User ID cannot be null or blank");
        }
    }
}
