package com.campusmov.platform.analyticsservice.analytics.application.internal.commandservices;

import com.campusmov.platform.analyticsservice.analytics.domain.model.aggregates.StudentRatingMetric;
import com.campusmov.platform.analyticsservice.analytics.domain.model.commands.CreateStudentRatingMetricsCommand;
import com.campusmov.platform.analyticsservice.analytics.domain.model.commands.UpdateStudentRatingMetricsCommand;
import com.campusmov.platform.analyticsservice.analytics.domain.service.StudentRatingMetricCommandService;
import com.campusmov.platform.analyticsservice.analytics.infrastructure.persistence.jpa.repositories.StudentRatingMetricRepository;
import org.springframework.stereotype.Service;

/**
 * Command service implementation that handles creation and update operations
 * for {@link StudentRatingMetric} aggregates.
 */
@Service
public class StudentRatingMetricCommandServiceImpl implements StudentRatingMetricCommandService {

    /**
     * Repository used to persist and retrieve student rating metrics.
     */
    private final StudentRatingMetricRepository studentRatingMetricRepository;

    /**
     * Constructs the command service with the required repository dependency.
     *
     * @param studentRatingMetricRepository repository for student rating metric persistence
     */
    public StudentRatingMetricCommandServiceImpl(StudentRatingMetricRepository studentRatingMetricRepository) {
        this.studentRatingMetricRepository = studentRatingMetricRepository;
    }

    /**
     * Handles the update of a student's rating metrics.
     * Retrieves the metric by user ID, updates its values, and persists the changes.
     *
     * @param command command containing the user ID and new reputation score
     * @throws IllegalArgumentException if the metric does not exist for the given user ID
     * @throws RuntimeException if the persistence operation fails
     */
    @Override
    public void handle(UpdateStudentRatingMetricsCommand command) {
        StudentRatingMetric studentRatingMetric = studentRatingMetricRepository.findByUserId(command.userId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Student rating metric not found for user ID: " + command.userId()
                ));

        studentRatingMetric.updateMetrics(command.reputationScore());

        try {
            studentRatingMetricRepository.save(studentRatingMetric);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update student rating metrics", e);
        }
    }

    /**
     * Handles the creation of a new student rating metric.
     * Initializes the aggregate using the provided command and stores it in the repository.
     *
     * @param command command containing the required initialization data
     * @throws RuntimeException if the persistence operation fails
     */
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
