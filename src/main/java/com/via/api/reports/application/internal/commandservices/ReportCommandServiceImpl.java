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
        // 1. Obtenemos el conteo actual para los nombres
        long currentCount = reportRepository.count();
        long nextId = currentCount + 1;
        String routeName = "Ruta " + nextId;
        String reportName = "Reporte " + nextId;

        // 2. Creamos el Reporte "padre"
        var report = new Report(routeName, reportName);

        // 3. Iteramos sobre los objetos del comando y los añadimos al padre
        command.detectedObjects().forEach(objCommand -> {
            report.addDetectedObject(objCommand.tagName(), objCommand.confidence());
        });

        // 4. Guardamos el reporte padre.
        // Gracias a "CascadeType.ALL", los hijos (DetectedObject) se guardarán automáticamente.
        reportRepository.save(report);
        return report.getId();
    }
}
