package com.campusmov.platform.analyticsservice.analytics.infrastructure.persistence.jpa.repositories;

import com.campusmov.platform.analyticsservice.analytics.domain.model.aggregates.StudentRatingMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRatingMetricRepository extends JpaRepository<StudentRatingMetric,String> {
    Optional<StudentRatingMetric> findByUserId(String userId);
}
