package com.musalasoft.drone.mgt.api.dao.entity;

import com.musalasoft.drone.mgt.api.enums.DroneModel;
import com.musalasoft.drone.mgt.api.enums.DroneState;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
public class Drone extends BaseEntity {

    private String serialNo;

    @Enumerated(EnumType.STRING)
    private DroneModel model;

    private Float weightLimit;

    private Float batteryCapacity;

    @Enumerated(EnumType.STRING)
    private DroneState state;
}
