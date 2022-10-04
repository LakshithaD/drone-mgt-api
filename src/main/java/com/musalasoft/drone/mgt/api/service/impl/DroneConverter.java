package com.musalasoft.drone.mgt.api.service.impl;

import com.musalasoft.drone.mgt.api.dao.entity.Drone;
import com.musalasoft.drone.mgt.api.dto.DroneDto;
import com.musalasoft.drone.mgt.api.dto.MedicationDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("serviceDroneConverter")
class DroneConverter {

    Drone convert(DroneDto droneDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(droneDto, Drone.class);
    }

    DroneDto convert(Drone drone) {
        ModelMapper modelMapper = new ModelMapper();
        List<MedicationDto> medicationDtos = drone.getMedications().stream()
                .map(medication -> modelMapper.map(medication, MedicationDto.class))
                .collect(Collectors.toList());
        DroneDto droneDto = modelMapper.map(drone, DroneDto.class);
        droneDto.setMedications(medicationDtos);
        return droneDto;
    }

    DroneDto convertDroneOnly(Drone drone) {
        ModelMapper modelMapper = new ModelMapper();
        DroneDto droneDto = modelMapper.map(drone, DroneDto.class);
        return droneDto;
    }


}
