package com.musalasoft.drone.mgt.api.controller.payload;

import lombok.Data;

@Data
public class MedicationRequest {

    private String name;
    private Float weight;
    private String code;
}
