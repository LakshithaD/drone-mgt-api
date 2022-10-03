package com.musalasoft.drone.mgt.api.dto;

import com.musalasoft.drone.mgt.api.enums.DroneModel;
import com.musalasoft.drone.mgt.api.enums.DroneState;
import lombok.Data;

import java.util.List;

@Data
public class DroneDto {

    private String serialNo;
    private DroneModel model;
    private Float weightLimit;
    private Float batteryCapacity;
    private DroneState state;
    private List<MedicationDto> medications;

}
