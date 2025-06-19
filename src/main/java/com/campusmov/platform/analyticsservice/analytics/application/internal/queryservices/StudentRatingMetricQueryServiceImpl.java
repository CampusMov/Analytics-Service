package com.campusmov.platform.analyticsservice.analytics.application.internal.queryservices;

import com.campusmov.platform.analyticsservice.analytics.domain.model.aggregates.StudentRatingMetric;
import com.campusmov.platform.analyticsservice.analytics.domain.model.queries.GetStudentRatingMetricQuery;
import com.campusmov.platform.analyticsservice.analytics.domain.service.StudentRatingMetricQueryService;
import com.campusmov.platform.analyticsservice.analytics.infrastructure.persistence.jpa.repositories.StudentRatingMetricRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentRatingMetricQueryServiceImpl implements StudentRatingMetricQueryService {
    private final StudentRatingMetricRepository studentRatingMetricRepository;

    public StudentRatingMetricQueryServiceImpl(StudentRatingMetricRepository studentRatingMetricRepository) {
        this.studentRatingMetricRepository = studentRatingMetricRepository;
    }

    @Override
    public Optional<StudentRatingMetric> handle(GetStudentRatingMetricQuery query) {
        return studentRatingMetricRepository.findByUserId(query.userId());
    }
}
