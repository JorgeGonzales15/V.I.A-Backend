package com.via.api.reports.interfaces.rest.resources;

public record CreateReportResource(String routeName, String reportName, String description, String tagName, Double confidence) {
}
