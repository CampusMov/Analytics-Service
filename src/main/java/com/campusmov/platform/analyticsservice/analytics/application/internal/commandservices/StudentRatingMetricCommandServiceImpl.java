package com.campusmov.platform.analyticsservice.analytics.application.internal.commandservices;

import com.campusmov.platform.analyticsservice.analytics.domain.model.aggregates.StudentRatingMetric;
import com.campusmov.platform.analyticsservice.analytics.domain.model.commands.CreateStudentRatingMetricsCommand;
import com.campusmov.platform.analyticsservice.analytics.domain.model.commands.UpdateStudentRatingMetricsCommand;
import com.campusmov.platform.analyticsservice.analytics.domain.service.StudentRatingMetricCommandService;
import com.campusmov.platform.analyticsservice.analytics.infrastructure.persistence.jpa.repositories.StudentRatingMetricRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentRatingMetricCommandServiceImpl implements StudentRatingMetricCommandService {
    private final StudentRatingMetricRepository studentRatingMetricRepository;

    public StudentRatingMetricCommandServiceImpl(StudentRatingMetricRepository studentRatingMetricRepository) {
        this.studentRatingMetricRepository = studentRatingMetricRepository;
    }

    @Override
    public void handle(UpdateStudentRatingMetricsCommand command) {
        StudentRatingMetric studentRatingMetric = studentRatingMetricRepository.findByUserId(command.userId())
                .orElseThrow(() -> new IllegalArgumentException("Student rating metric not found for user ID: "));

        studentRatingMetric.updateMetrics(command.reputationScore());

        try {
            studentRatingMetricRepository.save(studentRatingMetric);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update student rating metrics", e);
        }
    }

    @Override
    public void handle(CreateStudentRatingMetricsCommand command) {
        var studentRatingMetric = new StudentRatingMetric(command);

        try {
            studentRatingMetricRepository.save(studentRatingMetric);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create student rating metrics", e);
        }
    }
}
