package com.via.api.reports.domain.model.Entity;

import com.via.api.reports.domain.model.aggregates.Report;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "detected_objects")
public class DetectedObject {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String tagName;

    @Getter
    private Double confidence;

    // ----- RELACIÓN MUCHOS-A-UNO -----
    // El objeto "hijo" conoce a su "padre"
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id", nullable = false)
    private Report report;

    public DetectedObject() {
    }

    public DetectedObject(String tagName, Double confidence, Report report) {
        this.tagName = tagName;
        this.confidence = confidence;
        this.report = report;
    }
}
