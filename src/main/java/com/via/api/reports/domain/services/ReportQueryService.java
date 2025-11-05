package com.via.api.reports.domain.services;
import com.via.api.reports.domain.model.aggregates.Report;
import com.via.api.reports.domain.model.queries.GetAllReportsQuery;
import com.via.api.reports.domain.model.queries.GetReportByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ReportQueryService {
    List<Report> handle(GetAllReportsQuery query);
    Optional<Report> handle(GetReportByIdQuery query);
}
