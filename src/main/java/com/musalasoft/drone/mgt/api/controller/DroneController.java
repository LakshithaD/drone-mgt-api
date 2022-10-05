package com.musalasoft.drone.mgt.api.controller;

import com.musalasoft.drone.mgt.api.controller.payload.DroneCreateRequest;
import com.musalasoft.drone.mgt.api.controller.payload.DroneCreateResponse;
import com.musalasoft.drone.mgt.api.controller.payload.DroneLoadingRequest;
import com.musalasoft.drone.mgt.api.controller.payload.MedicationRequest;
import com.musalasoft.drone.mgt.api.dao.entity.Drone;
import com.musalasoft.drone.mgt.api.dto.DroneDto;
import com.musalasoft.drone.mgt.api.dto.MedicationDto;
import com.musalasoft.drone.mgt.api.service.DroneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/1/drones")
public class DroneController {

    private final DroneService droneService;

    @Qualifier("controllerMedicationConverter")
    private final MedicationConverter medicationConverter;

    @Qualifier("controllerDroneConverter")
    private final DroneConverter droneConverter;

    @PostMapping
    public DroneCreateResponse registerDrone(@Valid @RequestBody DroneCreateRequest request) {

        log.debug("Request Received to register Drone. - { }", request);
        DroneDto droneDto = droneConverter.convert(request);
        droneService.registerDrone(droneDto);
        return new DroneCreateResponse();
    }

    @PostMapping(path = "/{droneId}/medications")
    public void loadDroneMedications(@PathVariable Long droneId, @RequestPart("medication") String loadingRequest, @RequestPart("files") MultipartFile[] files) {

        log.debug("Request Received load drone {} with medications. - {}", droneId, loadingRequest);
        DroneLoadingRequest request = medicationConverter.convert(loadingRequest);
        List<MedicationDto> medicationDtos = request.getMedications()
                .stream()
                .map(medicationRequest -> medicationConverter.convert(medicationRequest))
                .collect(Collectors.toList());
        droneService.loadDroneWithMedicationItems(droneId, medicationDtos, files);
        log.debug("Drone medication loaded");
    }

    @GetMapping(path = "/{droneId}/medications")
    public List<MedicationDto> getDroneMedications(@PathVariable Long droneId) {

        log.debug("Request Received to get Drone. - { }", droneId);
        return droneService.getDroneLoadedMedicationItems(droneId);
    }

    @GetMapping(path = "/available")
    public List<DroneDto> getAvailableDronesForLoading() {

        log.debug("Request Received to get available Drone.");
        return droneService.getAvailableDronesForLoading();
    }

    @GetMapping(path = "{droneId}/battery")
    public String getDroneBatteryLevel(@PathVariable Long droneId) {

        log.debug("Request Received to get Drone battery level.");
        return droneService.getDroneBatteryLevel(droneId);
    }
}
