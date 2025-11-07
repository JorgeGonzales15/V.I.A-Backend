package com.via.api.reports.interfaces.rest.resources;

import java.util.List;

public record ReportResource(Long id, String routeName, String reportName, List<DetectedObjectResource> detectedObjects) {
}
