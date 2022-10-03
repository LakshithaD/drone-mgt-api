package com.musalasoft.drone.mgt.api.controller;

import com.musalasoft.drone.mgt.api.controller.payload.DroneCreateRequest;
import com.musalasoft.drone.mgt.api.dto.DroneDto;

abstract class DroneConverter {

    static DroneDto convert(DroneCreateRequest request) {

        DroneDto droneDto = new DroneDto();
        return droneDto;
    }
}
