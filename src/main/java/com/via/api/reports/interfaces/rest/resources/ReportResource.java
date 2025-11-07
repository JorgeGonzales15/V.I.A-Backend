package com.via.api.reports.interfaces.rest.resources;

public record ReportResource(Long id, String routeName, String reportName, String description, String tagName, Double confidence) {
}
