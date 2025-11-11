package com.via.api.sensors.domain.services;

import com.via.api.sensors.domain.model.aggregates.SensorReading;
import com.via.api.sensors.domain.model.queries.GetAllSensorReadingsQuery;
import com.via.api.sensors.domain.model.queries.GetSensorReadingByIdSensorQuery;

import java.util.List;
import java.util.Optional;

public interface SensorQueryService {
    List<SensorReading> handle(GetAllSensorReadingsQuery query);

    // Método para obtener un registro por idSensor
    Optional<SensorReading> handle(GetSensorReadingByIdSensorQuery query);
}
