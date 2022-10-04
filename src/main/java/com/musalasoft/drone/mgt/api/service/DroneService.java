package com.musalasoft.drone.mgt.api.service;

import com.musalasoft.drone.mgt.api.dto.DroneDto;
import com.musalasoft.drone.mgt.api.dto.MedicationDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DroneService {

    void registerDrone(DroneDto droneDto);

    void loadDroneWithMedicationItems(Long droneId, List<MedicationDto> medications, MultipartFile[] images);
    DroneDto getDrone(Long droneId);
    List<MedicationDto> getDroneLoadedMedicationItems(Long droneId);
}
