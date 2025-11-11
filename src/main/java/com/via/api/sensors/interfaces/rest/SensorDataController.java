package com.via.api.sensors.interfaces.rest;
import com.via.api.sensors.domain.model.commands.CreateSensorReadingCommand;
import com.via.api.sensors.domain.services.SensorCommandService;
import com.via.api.sensors.interfaces.rest.resources.CreateSensorDataResource;
import com.via.api.sensors.interfaces.rest.transform.CreateSensorReadingCommandFromResourceAssembler;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/sensor-data", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", maxAge = 3600)
public class SensorDataController {

    private final SensorCommandService sensorCommandService;


    public SensorDataController(SensorCommandService sensorCommandService) {
        this.sensorCommandService = sensorCommandService;
    }

    @PostMapping
    public ResponseEntity<String> receiveSensorData(@RequestBody CreateSensorDataResource resource) {

        var command = CreateSensorReadingCommandFromResourceAssembler.toCommandFromResource(resource);

        Long readingId = sensorCommandService.handle(command);

        return new ResponseEntity<>("Datos guardados con ID: " + readingId, HttpStatus.CREATED);
    }
}