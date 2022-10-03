package com.musalasoft.drone.mgt.api.controller;

import com.musalasoft.drone.mgt.api.controller.payload.DroneCreateRequest;
import com.musalasoft.drone.mgt.api.controller.payload.DroneCreateResponse;
import com.musalasoft.drone.mgt.api.dto.DroneDto;
import com.musalasoft.drone.mgt.api.dto.MedicationDto;
import com.musalasoft.drone.mgt.api.service.DroneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/drones")
public class DroneController {

    private final DroneService droneService;

    @PostMapping
    public DroneCreateResponse registerDrone(@Valid @RequestBody DroneCreateRequest request) {

        log.debug("Request Received to register Drone. - { }", request);
        DroneDto droneDto = DroneConverter.convert(request);
        droneService.registerDrone(droneDto);
        return new DroneCreateResponse();
    }

    @GetMapping(path = "/{droneId}")
    public DroneDto registerDrone(@PathVariable Long droneId) {

        log.debug("Request Received to get Drone. - { }", droneId);
        return droneService.getDrone(droneId);
    }

    @GetMapping(path = "/{droneId}/medications")
    public List<MedicationDto> getDroneMedications(@PathVariable Long droneId) {

        log.debug("Request Received to get Drone. - { }", droneId);
        return droneService.getDroneLoadedMedicationItems(droneId);
    }
}
