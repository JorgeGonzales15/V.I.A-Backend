package com.via.api.reports.infrastructure.persistence.jpa.repositories;

import com.via.api.reports.domain.model.aggregates.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
    // No se necesitan métodos custom para un "findAll"
}
