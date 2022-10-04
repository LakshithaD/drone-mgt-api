package com.musalasoft.drone.mgt.api.service.impl;

import com.musalasoft.drone.mgt.api.dao.entity.Drone;
import com.musalasoft.drone.mgt.api.dao.entity.Medication;
import com.musalasoft.drone.mgt.api.dto.MedicationDto;
import org.modelmapper.ModelMapper;

abstract class MedicationConverter {

    static MedicationDto convert(Medication medication) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(medication, MedicationDto.class);
    }

    static Medication convert(MedicationDto medicationDto, Drone drone) {

        ModelMapper modelMapper = new ModelMapper();
        Medication medication = modelMapper.map(medicationDto, Medication.class);
        medication.setDrone(drone);
        return medication;
    }
}
