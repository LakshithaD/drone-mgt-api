package com.musalasoft.drone.mgt.api.service.impl;

import com.musalasoft.drone.mgt.api.dao.entity.Drone;
import com.musalasoft.drone.mgt.api.dto.DroneDto;
import org.modelmapper.ModelMapper;

abstract class DroneConverter {

    static Drone convert(DroneDto droneDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(droneDto, Drone.class);
    }


}
