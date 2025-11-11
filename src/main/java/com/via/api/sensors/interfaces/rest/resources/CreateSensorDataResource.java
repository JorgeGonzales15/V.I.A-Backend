package com.via.api.sensors.interfaces.rest.resources;


public record CreateSensorDataResource(
        Double temperatura,
        Double humedad,
        Double distancia,
        String id_sensor
) {}