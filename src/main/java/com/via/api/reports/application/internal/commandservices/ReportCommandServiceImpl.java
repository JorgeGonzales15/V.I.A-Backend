package com.via.api.reports.application.internal.commandservices;

import com.via.api.reports.domain.model.aggregates.Report;
import com.via.api.reports.domain.model.commands.CreateReportCommand;
import com.via.api.reports.domain.services.ReportCommandService;
import com.via.api.reports.infrastructure.persistence.jpa.repositories.ReportRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportCommandServiceImpl implements ReportCommandService {

    private final ReportRepository reportRepository;

    public ReportCommandServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Long handle(CreateReportCommand command) {
        var report = new Report(command.reportName(), command.description(), command.tagName(), command.confidence());
        reportRepository.save(report);
        return report.getId();
    }
}
