package com.via.api.reports.application.internal.queryservice;

import com.via.api.reports.domain.model.aggregates.Report;
import com.via.api.reports.domain.model.queries.GetAllReportsQuery;
import com.via.api.reports.domain.model.queries.GetReportByIdQuery;
import com.via.api.reports.domain.services.ReportQueryService;
import com.via.api.reports.infrastructure.persistence.jpa.repositories.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportQueryServiceImpl implements ReportQueryService {
    private final ReportRepository reportRepository;

    public ReportQueryServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public List<Report> handle(GetAllReportsQuery query) {
        return reportRepository.findAll();
    }

    @Override
    public Optional<Report> handle(GetReportByIdQuery query) {
        return reportRepository.findById(query.id());
    }
}
