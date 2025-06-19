package com.campusmov.platform.analyticsservice.analytics.interfaces.rest.controllers;

import com.campusmov.platform.analyticsservice.analytics.domain.model.queries.GetStudentRatingMetricQuery;
import com.campusmov.platform.analyticsservice.analytics.domain.service.StudentRatingMetricQueryService;
import com.campusmov.platform.analyticsservice.analytics.interfaces.rest.resources.StudentRatingMetricResource;
import com.campusmov.platform.analyticsservice.analytics.interfaces.rest.transform.StudentRatingMetricResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("analytics/student-metrics")
@Tag(name = "student-metrics", description = "Student Metrics Endpoints")
public class StudentMetricController {
    private final StudentRatingMetricQueryService studentRatingMetricQueryService;

    public StudentMetricController(StudentRatingMetricQueryService studentRatingMetricQueryService) {
        this.studentRatingMetricQueryService = studentRatingMetricQueryService;
    }

    @GetMapping("{userId}")
    @Operation(summary = "Get student rating metrics", description = "Retrieves the rating metrics for a specific student by user ID", operationId = "get-student-rating-metrics")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student rating metrics retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    public ResponseEntity<StudentRatingMetricResource> getStudentRatingMetrics(@PathVariable String userId) {
        var query = new GetStudentRatingMetricQuery(userId);
        var studentRatingMetric = studentRatingMetricQueryService.handle(query);
        var studentRatingMetricResource = StudentRatingMetricResourceFromEntityAssembler.toResourceFromEntity(studentRatingMetric.get());
        return ResponseEntity.ok(studentRatingMetricResource);
    }

}
