package com.via.api.sensors.application.internal.commandservice;

import com.via.api.sensors.domain.model.aggregates.SensorReading;
import com.via.api.sensors.domain.model.commands.CreateSensorReadingCommand;
import com.via.api.sensors.domain.services.SensorCommandService;
import com.via.api.sensors.infrastructure.persistence.jpa.repositories.SensorReadingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SensorCommandServiceImpl implements SensorCommandService {

    private final SensorReadingRepository sensorReadingRepository;

    public SensorCommandServiceImpl(SensorReadingRepository sensorReadingRepository) {
        this.sensorReadingRepository = sensorReadingRepository;
    }

    @Override
    public Long handle(CreateSensorReadingCommand command) {

        Optional<SensorReading> existingReading =
                sensorReadingRepository.findByIdSensor(command.idSensor());

        SensorReading sensorReadingToSave;

        if (existingReading.isPresent()) {

            sensorReadingToSave = existingReading.get();

            sensorReadingToSave.setTemperatura(command.temperatura());
            sensorReadingToSave.setHumedad(command.humedad());
            sensorReadingToSave.setDistancia(command.distancia());


        } else {
            sensorReadingToSave = new SensorReading(
                    command.temperatura(),
                    command.humedad(),
                    command.distancia(),
                    command.idSensor()
            );
        }

        sensorReadingRepository.save(sensorReadingToSave);

        return sensorReadingToSave.getId();
    }
}