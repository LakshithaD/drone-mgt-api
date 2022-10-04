package com.musalasoft.drone.mgt.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musalasoft.drone.mgt.api.controller.payload.DroneLoadingRequest;
import com.musalasoft.drone.mgt.api.controller.payload.MedicationRequest;
import com.musalasoft.drone.mgt.api.dao.entity.Medication;
import com.musalasoft.drone.mgt.api.dto.MedicationDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("controllerMedicationConverter")
@RequiredArgsConstructor
class MedicationConverter {

    private final ModelMapper modelMapper;

    MedicationDto convert(MedicationRequest request) {

        return modelMapper.map(request, MedicationDto.class);
    }

    DroneLoadingRequest convert(String request) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(request, DroneLoadingRequest.class);
        } catch (JsonProcessingException e) {

            return null;
        }
    }
}
