package com.campusmov.platform.analyticsservice.analytics.domain.model.aggregates;

import com.campusmov.platform.analyticsservice.analytics.domain.model.commands.CreateStudentRatingMetricsCommand;
import com.campusmov.platform.analyticsservice.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StudentRatingMetric extends AuditableAbstractAggregateRoot<StudentRatingMetric> {

    /**
     * Identifier of the student associated with this rating metric.
     */
    @NotBlank
    private String userId;

    /**
     * Sum of all rating values received by the student.
     */
    @NotNull
    private Double totalRatings;

    /**
     * Total number of reviews submitted for the student.
     */
    @NotNull
    private Integer totalReviewsCount;

    /**
     * Average rating calculated from all submitted reviews.
     */
    @NotNull
    private Double averageRating;

    /**
     * Default constructor required by JPA.
     */
    public StudentRatingMetric() {
    }

    /**
     * Creates a new StudentRatingMetric initialized with default rating values.
     *
     * @param command command containing the student's identifier
     */
    public StudentRatingMetric(CreateStudentRatingMetricsCommand command) {
        this.userId = command.userId();
        this.totalRatings = 5.0;
        this.totalReviewsCount = 0;
        this.averageRating = 5.0;
    }

    /**
     * Updates rating metrics based on a new reputation score.
     * Validates input, adds the score, increments the review counter,
     * and recalculates the average rating.
     *
     * @param reputationScore new score to incorporate into the metrics
     * @throws IllegalArgumentException if the score is null or negative
     */
    public void updateMetrics(Double reputationScore) {
        if (reputationScore == null || reputationScore < 0) {
            throw new IllegalArgumentException("Reputation score must be a non-negative number");
        }
        if (this.totalReviewsCount == 0) this.totalRatings = reputationScore;
        else this.totalRatings += reputationScore;

        this.totalReviewsCount++;
        this.averageRating = this.totalRatings / this.totalReviewsCount;
    }
}
