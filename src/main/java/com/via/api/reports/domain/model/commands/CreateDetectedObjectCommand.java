package com.via.api.reports.domain.model.commands;

public record CreateDetectedObjectCommand(String tagName, Double confidence) {
}
