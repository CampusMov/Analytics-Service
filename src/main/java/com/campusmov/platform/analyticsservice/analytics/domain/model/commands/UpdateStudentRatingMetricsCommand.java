package com.campusmov.platform.analyticsservice.analytics.domain.model.commands;

public record UpdateStudentRatingMetricsCommand(String userId, Double reputationScore) {
    public UpdateStudentRatingMetricsCommand {
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
        if (reputationScore == null || reputationScore < 0.0 || reputationScore > 5.0) {
            throw new IllegalArgumentException("Reputation score must be between 0.0 and 5.0");
        }
    }
}
