package com.via.api.reports.interfaces.rest.resources;

import java.util.List;

public record CreateReportResource(List<DetectedObjectResource> detectedObjects) {
}
