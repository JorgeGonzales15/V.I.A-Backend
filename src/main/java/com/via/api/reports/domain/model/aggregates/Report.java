package com.via.api.reports.domain.model.aggregates;
import com.via.api.reports.domain.model.Entity.DetectedObject;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Entity
@Table(name = "reports")
public class Report {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String routeName;

    @Getter
    private String reportName;

    // ----- RELACIÓN UNO-A-MUCHOS -----
    @Getter
    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DetectedObject> detectedObjects = new ArrayList<>();

    public Report() {
    }

    // El constructor solo necesita los nombres, la lista se llena después
    public Report(String routeName, String reportName) {
        this.routeName = routeName;
        this.reportName = reportName;
    }

    // ----- MÉTODO AYUDANTE -----
    // Para añadir objetos y mantener la relación sincronizada
    public void addDetectedObject(String tagName, Double confidence) {
        DetectedObject object = new DetectedObject(tagName, confidence, this);
        this.detectedObjects.add(object);
    }
}
