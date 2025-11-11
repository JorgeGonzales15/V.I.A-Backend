package com.via.api.sensors.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "sensor_readings")
public class SensorReading {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private Double temperatura;

    @Getter
    @Setter
    private Double humedad;

    @Getter
    @Setter
    private Double distancia;

    @Getter
    @Column(unique = true, nullable = false)
    private String idSensor;

    @Getter
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;


    public SensorReading() {
    }

    public SensorReading(Double temperatura, Double humedad, Double distancia, String idSensor) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.distancia = distancia;
        this.idSensor = idSensor;
    }
}