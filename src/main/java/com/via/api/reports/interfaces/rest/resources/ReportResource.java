package com.via.api.reports.interfaces.rest.resources;

public record ReportResource(Long id, String reportName, String description, String tagName, Double confidence) {
}
