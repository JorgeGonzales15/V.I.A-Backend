package com.via.api.sensors.application.internal.queryservice;

import com.via.api.sensors.domain.model.aggregates.SensorReading;
import com.via.api.sensors.domain.model.queries.GetAllSensorReadingsQuery;
import com.via.api.sensors.domain.model.queries.GetSensorReadingByIdSensorQuery;
import com.via.api.sensors.domain.services.SensorQueryService;
import com.via.api.sensors.infrastructure.persistence.jpa.repositories.SensorReadingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorQueryServiceImpl implements SensorQueryService {

    private final SensorReadingRepository sensorReadingRepository;

    public SensorQueryServiceImpl(SensorReadingRepository sensorReadingRepository) {
        this.sensorReadingRepository = sensorReadingRepository;
    }

    @Override
    public List<SensorReading> handle(GetAllSensorReadingsQuery query) {
        // Simplemente llamamos al método findAll() del repositorio
        return sensorReadingRepository.findAll();
    }

    @Override
    public Optional<SensorReading> handle(GetSensorReadingByIdSensorQuery query) {
        // Usamos el método que ya tenías definido en el repositorio
        return sensorReadingRepository.findByIdSensor(query.idSensor());
    }
}