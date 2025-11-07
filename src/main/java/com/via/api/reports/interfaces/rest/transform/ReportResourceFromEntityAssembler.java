package com.via.api.reports.interfaces.rest.transform;

import com.via.api.reports.domain.model.aggregates.Report;
import com.via.api.reports.interfaces.rest.resources.ReportResource;

public class ReportResourceFromEntityAssembler {
    public static ReportResource toResourceFromEntity(Report entity) {
        return new ReportResource(
                entity.getId(),
                entity.getRouteName(),
                entity.getReportName(),
                entity.getDescription(),
                entity.getTagName(),
                entity.getConfidence()
        );
    }
}
