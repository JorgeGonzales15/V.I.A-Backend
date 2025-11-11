package com.via.api.sensors.interfaces.rest.transform;

import com.via.api.sensors.domain.model.commands.CreateSensorReadingCommand;
import com.via.api.sensors.interfaces.rest.resources.CreateSensorDataResource;

public class CreateSensorReadingCommandFromResourceAssembler {

    public static CreateSensorReadingCommand toCommandFromResource(CreateSensorDataResource resource) {
        return new CreateSensorReadingCommand(
                resource.temperatura(),
                resource.humedad(),
                resource.distancia(),
                resource.id_sensor() // Cambiado de idSensor() a id_sensor()
        );
    }
}