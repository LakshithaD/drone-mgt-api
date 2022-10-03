package com.musalasoft.drone.mgt.api.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Medication extends BaseEntity {

    private String name;
    private Float weight;
    private String code;
    private String imagePath;
    @ManyToOne
    @JoinColumn(name = "drone_id", nullable = false)
    private Drone drone;
}
