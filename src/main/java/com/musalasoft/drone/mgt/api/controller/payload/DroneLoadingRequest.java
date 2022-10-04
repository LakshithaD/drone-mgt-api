package com.musalasoft.drone.mgt.api.controller.payload;

import lombok.Data;

import java.util.List;

@Data
public class DroneLoadingRequest extends Request {

   private List<MedicationRequest> medications;

}
