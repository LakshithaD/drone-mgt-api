package com.musalasoft.drone.mgt.api.service;

import com.musalasoft.drone.mgt.api.dto.DroneDto;
import com.musalasoft.drone.mgt.api.dto.MedicationDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DroneService {

    /**
     * Register a drone in the system
     * @param droneDto Information of the drone
     */
    void registerDrone(DroneDto droneDto);

    /**
     * Load the drone with medication items
     * @param droneId Id of the drone to load medications
     * @param medications Medication items
     * @param images List of images belongs to the medications.
     */
    void loadDroneWithMedicationItems(Long droneId, List<MedicationDto> medications, MultipartFile[] images);
    DroneDto getDrone(Long droneId);

    /**
     * Get the medication items loaded in the drone
     * @param droneId ID of the drone
     * @return List of medication items
     */
    List<MedicationDto> getDroneLoadedMedicationItems(Long droneId);

    /**
     * Get the available drones for loading
     * @return List of available drones for loading
     */
    List<DroneDto> getAvailableDronesForLoading();

    /**
     * The method to get drone battery level
     * @param droneId ID of the drone
     * @return Battery level percentage
     */
    String getDroneBatteryLevel(Long droneId);
}
