package com.musalasoft.drone.mgt.api.dao.repository;

import com.musalasoft.drone.mgt.api.dao.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone, Long> {
    Boolean existsBySerialNo(String serialNo);
}
