package com.musalasoft.drone.mgt.api.service.impl;

import com.musalasoft.drone.mgt.api.dao.entity.Drone;
import com.musalasoft.drone.mgt.api.dto.DroneDto;
abstract class DroneConverter {

    static Drone convert(DroneDto droneDto) {

        Drone drone = new Drone();
        return drone;
    }


}
