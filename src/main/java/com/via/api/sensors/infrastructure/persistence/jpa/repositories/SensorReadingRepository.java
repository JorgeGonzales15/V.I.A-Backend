package com.via.api.sensors.infrastructure.persistence.jpa.repositories;

import com.via.api.sensors.domain.model.aggregates.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SensorReadingRepository extends JpaRepository<SensorReading, Long> {

    Optional<SensorReading> findByIdSensor(String idSensor);
}