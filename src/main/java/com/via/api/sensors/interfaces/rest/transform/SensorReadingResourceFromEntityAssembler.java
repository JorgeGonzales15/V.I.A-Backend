package com.via.api.sensors.interfaces.rest.transform;

import com.via.api.sensors.domain.model.aggregates.SensorReading;
import com.via.api.sensors.interfaces.rest.resources.SensorReadingResource;

import java.util.List;
import java.util.stream.Collectors;

public class SensorReadingResourceFromEntityAssembler {

    // Convierte una (1) entidad a un recurso
    public static SensorReadingResource toResourceFromEntity(SensorReading entity) {
        return new SensorReadingResource(
                entity.getId(),
                entity.getTemperatura(),
                entity.getHumedad(),
                entity.getDistancia(),
                entity.getIdSensor(),
                entity.getCreatedAt()
        );
    }

    // Convierte una lista de entidades a una lista de recursos
    public static List<SensorReadingResource> toResourceListFromEntities(List<SensorReading> entities) {
        return entities.stream()
                .map(SensorReadingResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
    }
}
