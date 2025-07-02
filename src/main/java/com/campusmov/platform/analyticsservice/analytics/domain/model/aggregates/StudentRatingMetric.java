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

    @NotBlank
    private String userId;

    @NotNull
    private Double totalRatings;

    @NotNull
    private Integer totalReviewsCount;

    @NotNull
    private Double averageRating;

    public StudentRatingMetric() {
    }

    public StudentRatingMetric(CreateStudentRatingMetricsCommand command) {
        this.userId = command.userId();
        this.totalRatings = 5.0;
        this.totalReviewsCount = 0;
        this.averageRating = 5.0;
    }

    public void updateMetrics(Double reputationScore){
        if (reputationScore == null || reputationScore < 0) {
            throw new IllegalArgumentException("Reputation score must be a non-negative number");
        }
        if(this.totalReviewsCount == 0) this.totalRatings = reputationScore;
        else this.totalRatings += reputationScore;

        this.totalReviewsCount++;
        this.averageRating = this.totalRatings / this.totalReviewsCount;
    }

}
