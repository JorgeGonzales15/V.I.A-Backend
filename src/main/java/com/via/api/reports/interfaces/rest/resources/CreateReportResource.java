package com.via.api.reports.interfaces.rest.resources;

public record CreateReportResource(String reportName, String description, String tagName, Double confidence) {
}
