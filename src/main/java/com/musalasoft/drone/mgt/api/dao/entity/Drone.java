package com.musalasoft.drone.mgt.api.dao.entity;

import com.musalasoft.drone.mgt.api.enums.DroneModel;
import com.musalasoft.drone.mgt.api.enums.DroneState;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Drone extends BaseEntity {

    private Integer serialNo;

    @Enumerated(EnumType.STRING)
    private DroneModel model;

    private Float weightLimit;

    private Float batteryCapacity;

    @Enumerated(EnumType.STRING)
    private DroneState state;
}
