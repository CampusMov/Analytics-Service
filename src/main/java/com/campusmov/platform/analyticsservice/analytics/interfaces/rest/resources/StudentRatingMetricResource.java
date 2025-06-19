package com.campusmov.platform.analyticsservice.analytics.interfaces.rest.resources;

public record StudentRatingMetricResource(String userId, Double totalRatings, Integer totalReviewsCount, Double averageRating) {

    public StudentRatingMetricResource {
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("userId is required");
        }
        if (totalRatings == null || totalRatings < 0.0) {
            throw new IllegalArgumentException("totalRatings must be a non-negative number");
        }
        if (totalReviewsCount == null || totalReviewsCount < 0) {
            throw new IllegalArgumentException("totalReviewsCount must be a non-negative integer");
        }
        if (averageRating == null || averageRating < 0.0 || averageRating > 5.0) {
            throw new IllegalArgumentException("averageRating must be between 0.0 and 5.0");
        }
    }
}
