package com.musalasoft.drone.mgt.api.service;

import com.musalasoft.drone.mgt.api.dto.DroneDto;
import com.musalasoft.drone.mgt.api.dto.MedicationDto;

import java.util.List;

public interface DroneService {

    void registerDrone(DroneDto droneDto);
    DroneDto getDrone(Long droneId);
    List<MedicationDto> getDroneLoadedMedicationItems(Long droneId);
}
