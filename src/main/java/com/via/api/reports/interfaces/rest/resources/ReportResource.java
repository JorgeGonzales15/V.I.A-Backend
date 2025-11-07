package com.via.api.reports.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record ReportResource(Long id, String routeName, String reportName, List<DetectedObjectResource> detectedObjects, @JsonFormat(pattern = "dd-MM-yyyy") LocalDateTime createdAt) {
}
