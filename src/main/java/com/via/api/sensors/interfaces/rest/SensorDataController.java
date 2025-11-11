package com.via.api.sensors.interfaces.rest;
import com.via.api.sensors.domain.model.commands.CreateSensorReadingCommand;
import com.via.api.sensors.domain.model.queries.GetAllSensorReadingsQuery;
import com.via.api.sensors.domain.model.queries.GetSensorReadingByIdSensorQuery;
import com.via.api.sensors.domain.services.SensorCommandService;
import com.via.api.sensors.domain.services.SensorQueryService;
import com.via.api.sensors.interfaces.rest.resources.CreateSensorDataResource;
import com.via.api.sensors.interfaces.rest.resources.SensorReadingResource;
import com.via.api.sensors.interfaces.rest.transform.CreateSensorReadingCommandFromResourceAssembler;

import com.via.api.sensors.interfaces.rest.transform.SensorReadingResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/sensor-data", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", maxAge = 3600)
public class SensorDataController {

    private final SensorCommandService sensorCommandService;
    private final SensorQueryService sensorQueryService; // Inyectar el nuevo servicio

    // Actualizar el constructor
    public SensorDataController(SensorCommandService sensorCommandService, SensorQueryService sensorQueryService) {
        this.sensorCommandService = sensorCommandService;
        this.sensorQueryService = sensorQueryService;
    }

    @PostMapping
    public ResponseEntity<String> receiveSensorData(@RequestBody CreateSensorDataResource resource) {
        var command = CreateSensorReadingCommandFromResourceAssembler.toCommandFromResource(resource);
        Long readingId = sensorCommandService.handle(command);
        return new ResponseEntity<>("Datos guardados con ID: " + readingId, HttpStatus.CREATED);
    }

    // --- NUEVO ENDPOINT: GET PARA TODOS ---
    @GetMapping
    public ResponseEntity<List<SensorReadingResource>> getAllSensorData() {
        var query = new GetAllSensorReadingsQuery();
        var readings = sensorQueryService.handle(query);

        // Usamos el nuevo assembler para convertir la lista de entidades
        var resources = SensorReadingResourceFromEntityAssembler.toResourceListFromEntities(readings);

        return ResponseEntity.ok(resources);
    }

    // --- NUEVO ENDPOINT: GET POR IDSENSOR ---
    @GetMapping("/{idSensor}")
    public ResponseEntity<SensorReadingResource> getSensorDataByIdSensor(@PathVariable String idSensor) {
        var query = new GetSensorReadingByIdSensorQuery(idSensor);
        var reading = sensorQueryService.handle(query);

        if (reading.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Usamos el assembler para convertir la entidad encontrada
        var resource = SensorReadingResourceFromEntityAssembler.toResourceFromEntity(reading.get());

        return ResponseEntity.ok(resource);
    }
}