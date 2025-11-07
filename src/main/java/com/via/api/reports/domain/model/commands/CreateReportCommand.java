package com.via.api.reports.domain.model.commands;

public record CreateReportCommand(String routeName, String reportName, String description, String tagName, Double confidence) {
}
