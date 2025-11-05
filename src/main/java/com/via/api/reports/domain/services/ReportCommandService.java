package com.via.api.reports.domain.services;

import com.via.api.reports.domain.model.commands.CreateReportCommand;

public interface ReportCommandService {
    Long handle(CreateReportCommand command);
}