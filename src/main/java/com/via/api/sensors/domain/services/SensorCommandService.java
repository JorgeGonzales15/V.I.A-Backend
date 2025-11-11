package com.via.api.sensors.domain.services;

import com.via.api.sensors.domain.model.commands.CreateSensorReadingCommand;

public interface SensorCommandService {
    Long handle(CreateSensorReadingCommand command);
}