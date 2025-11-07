package com.via.api.reports.domain.model.aggregates;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@Entity
@Table(name = "reports")
public class Report {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Spring sabe que esto es 'id'

    @Getter
    // SIN @Column. Spring lo mapeará a 'report_name'
    private String routeName;

    @Getter
    // SIN @Column. Spring lo mapeará a 'report_name'
    private String reportName;

    @Getter
    private String description;

    @Getter
    // SIN @Column. Spring lo mapeará a 'tag_name'
    private String tagName;

    @Getter
    private Double confidence;

    public Report() {
    }

    // El constructor usa los nombres de Java (camelCase)
    public Report(String routeName, String reportName, String description, String tagName, Double confidence) {
        this.routeName = routeName;
        this.reportName = reportName;
        this.description = description;
        this.tagName = tagName;
        this.confidence = confidence;
    }
}
