package com.musalasoft.drone.mgt.api.controller;

import com.musalasoft.drone.mgt.api.controller.payload.DroneCreateRequest;
import com.musalasoft.drone.mgt.api.dto.DroneDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("controllerDroneConverter")
class DroneConverter {

    DroneDto convert(DroneCreateRequest request) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(request, DroneDto.class);
    }



}
