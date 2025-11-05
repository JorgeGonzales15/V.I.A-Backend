package com.via.api.reports.domain.model.aggregates;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "reports")
public class Report {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String reportName;

    @Getter
    private String description;

    @Getter
    private String tagName;

    @Getter
    private Double confidence;

    public Report() {
    }

    public Report(String reportName, String description, String tagName, Double confidence) {
        this.reportName = reportName;
        this.description = description;
        this.tagName = tagName;
        this.confidence = confidence;
    }
}
