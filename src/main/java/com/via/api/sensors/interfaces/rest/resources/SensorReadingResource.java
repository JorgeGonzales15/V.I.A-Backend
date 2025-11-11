package com.via.api.sensors.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record SensorReadingResource(
        Long id,
        Double temperatura,
        Double humedad,
        Double distancia,
        String idSensor,
        @JsonFormat(pattern = "dd-MM-yyyy") LocalDateTime createdAt
) {}
