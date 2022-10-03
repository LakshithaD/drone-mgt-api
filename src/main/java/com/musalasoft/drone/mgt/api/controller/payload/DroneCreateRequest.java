package com.musalasoft.drone.mgt.api.controller.payload;

import com.musalasoft.drone.mgt.api.enums.DroneModel;
import com.musalasoft.drone.mgt.api.enums.DroneState;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;

@Data
public class DroneCreateRequest extends Request {

    @Size(min = 1, max = 100)
    private String serialNo;
    private DroneModel model;
    @Range(min = 1, max = 500)
    private Float weightLimit;
    @Range(min = 1, max = 100)
    private Float batteryCapacity;
    private DroneState state;
}
