package com.campusmov.platform.analyticsservice.analytics.domain.model.commands;

public record CreateStudentRatingMetricsCommand(String userId) {

    public CreateStudentRatingMetricsCommand {
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
    }
}
