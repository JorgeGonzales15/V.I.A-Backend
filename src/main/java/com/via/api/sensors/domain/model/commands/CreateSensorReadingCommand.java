package com.via.api.sensors.domain.model.commands;

public record CreateSensorReadingCommand(
        Double temperatura,
        Double humedad,
        Double distancia,
        String idSensor
) {}