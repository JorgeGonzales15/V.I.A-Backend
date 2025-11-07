package com.via.api.reports.interfaces.rest.transform;

import com.via.api.reports.domain.model.commands.CreateDetectedObjectCommand;
import com.via.api.reports.domain.model.commands.CreateReportCommand;
import com.via.api.reports.interfaces.rest.resources.CreateReportResource;

import java.util.stream.Collectors;

public class CreateReportCommandFromResourceAssembler {
    public static CreateReportCommand toCommandFromResource(CreateReportResource resource) {
        // Mapeamos la lista de resources a una lista de commands
        var detectedObjectCommands = resource.detectedObjects().stream()
                .map(obj -> new CreateDetectedObjectCommand(obj.tagName(), obj.confidence()))
                .collect(Collectors.toList());

        return new CreateReportCommand(detectedObjectCommands);
    }
}
