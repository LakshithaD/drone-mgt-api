package com.musalasoft.drone.mgt.api.service;

import com.musalasoft.drone.mgt.api.dao.entity.Drone;
import com.musalasoft.drone.mgt.api.dao.repository.DroneRepository;
import com.musalasoft.drone.mgt.api.service.impl.DroneServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class DroneServiceTest {

    @Mock
    private DroneRepository droneRepository;

    @InjectMocks
    private DroneServiceImpl droneService;

    @Test
    void getDroneBatteryLevel() {

        Drone drone = new Drone();
        drone.setBatteryCapacity(87.8f);
        given(droneRepository.findById(anyLong())).willReturn(Optional.of(drone));

        String batteryLevel = droneService.getDroneBatteryLevel(2l);
        Assertions.assertEquals("87.8%", batteryLevel);
    }
}