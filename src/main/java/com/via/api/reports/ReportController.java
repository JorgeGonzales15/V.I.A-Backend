package com.via.api.reports;

import com.via.api.reports.domain.model.queries.GetAllReportsQuery;
import com.via.api.reports.domain.model.queries.GetReportByIdQuery;
import com.via.api.reports.domain.services.ReportCommandService;
import com.via.api.reports.domain.services.ReportQueryService;
import com.via.api.reports.interfaces.rest.resources.CreateReportResource;
import com.via.api.reports.interfaces.rest.resources.ReportResource;
import com.via.api.reports.interfaces.rest.transform.CreateReportCommandFromResourceAssembler;
import com.via.api.reports.interfaces.rest.transform.ReportResourceFromEntityAssembler;
import io.swagger.annotations.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1/reports", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {

    private final ReportCommandService reportCommandService;
    private final ReportQueryService reportQueryService;

    public ReportController(ReportCommandService reportCommandService, ReportQueryService reportQueryService) {
        this.reportCommandService = reportCommandService;
        this.reportQueryService = reportQueryService;
    }

    /**
     * Endpoint para crear un nuevo reporte.
     */
    @PostMapping
    public ResponseEntity<ReportResource> createReport(@RequestBody CreateReportResource resource) {
        var createReportCommand = CreateReportCommandFromResourceAssembler.toCommandFromResource(resource);
        var reportId = reportCommandService.handle(createReportCommand);

        if (reportId == 0L) {
            return ResponseEntity.badRequest().build();
        }

        var getReportByIdQuery = new GetReportByIdQuery(reportId);
        var report = reportQueryService.handle(getReportByIdQuery);

        if (report.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var reportResource = ReportResourceFromEntityAssembler.toResourceFromEntity(report.get());
        return new ResponseEntity<>(reportResource, HttpStatus.CREATED);
    }

    /**
     * Endpoint para obtener todos los reportes.
     */
    @GetMapping
    public ResponseEntity<List<ReportResource>> getAllReports() {
        var getAllReportsQuery = new GetAllReportsQuery();
        var reports = reportQueryService.handle(getAllReportsQuery);

        var reportResources = reports.stream()
                .map(ReportResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(reportResources);
    }
}
