package com.via.api.reports.interfaces.rest.transform;

import com.via.api.reports.domain.model.commands.CreateReportCommand;
import com.via.api.reports.interfaces.rest.resources.CreateReportResource;

public class CreateReportCommandFromResourceAssembler {
    public static CreateReportCommand toCommandFromResource(CreateReportResource resource) {
        return new CreateReportCommand(
                resource.reportName(),
                resource.description(),
                resource.tagName(),
                resource.confidence()
        );
    }
}
