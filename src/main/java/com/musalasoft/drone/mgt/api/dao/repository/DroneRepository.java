package com.musalasoft.drone.mgt.api.dao.repository;

import com.musalasoft.drone.mgt.api.dao.entity.Drone;
import com.musalasoft.drone.mgt.api.enums.DroneState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DroneRepository extends JpaRepository<Drone, Long> {
    Boolean existsBySerialNo(String serialNo);

    List<Drone> findByStateIn(List<DroneState> droneStates);
}
