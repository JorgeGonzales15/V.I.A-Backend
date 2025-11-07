package com.via.api.reports.interfaces.rest.transform;

import com.via.api.reports.domain.model.aggregates.Report;
import com.via.api.reports.interfaces.rest.resources.DetectedObjectResource;
import com.via.api.reports.interfaces.rest.resources.ReportResource;

import java.util.stream.Collectors;

public class ReportResourceFromEntityAssembler {
    public static ReportResource toResourceFromEntity(Report entity) {
        // Mapeamos la lista de entidades a una lista de resources
        var detectedObjectResources = entity.getDetectedObjects().stream()
                .map(obj -> new DetectedObjectResource(obj.getTagName(), obj.getConfidence()))
                .collect(Collectors.toList());

        return new ReportResource(
                entity.getId(),
                entity.getRouteName(),
                entity.getReportName(),
                detectedObjectResources,
                entity.getCreatedAt()
        );
    }
}
