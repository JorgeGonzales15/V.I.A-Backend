package com.via.api.reports.domain.model.commands;

import java.util.List;

public record CreateReportCommand(List<CreateDetectedObjectCommand> detectedObjects) {
}
