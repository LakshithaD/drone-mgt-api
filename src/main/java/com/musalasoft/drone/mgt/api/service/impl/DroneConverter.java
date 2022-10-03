package com.musalasoft.drone.mgt.api.service.impl;

import com.musalasoft.drone.mgt.api.dao.entity.Drone;
import com.musalasoft.drone.mgt.api.dto.DroneDto;
import com.musalasoft.drone.mgt.api.dto.MedicationDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

abstract class DroneConverter {

    static Drone convert(DroneDto droneDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(droneDto, Drone.class);
    }

    static DroneDto convert(Drone drone) {
        ModelMapper modelMapper = new ModelMapper();
        List<MedicationDto> medicationDtos = drone.getMedications().stream()
                .map(medication -> modelMapper.map(medication, MedicationDto.class))
                .collect(Collectors.toList());
        DroneDto droneDto = modelMapper.map(drone, DroneDto.class);
        droneDto.setMedications(medicationDtos);
        return droneDto;
    }


}
