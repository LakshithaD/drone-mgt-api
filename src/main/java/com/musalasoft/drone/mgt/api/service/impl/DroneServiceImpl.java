package com.musalasoft.drone.mgt.api.service.impl;

import com.musalasoft.drone.mgt.api.dao.entity.Drone;
import com.musalasoft.drone.mgt.api.dao.repository.DroneRepository;
import com.musalasoft.drone.mgt.api.dto.DroneDto;
import com.musalasoft.drone.mgt.api.excetions.ValidationException;
import com.musalasoft.drone.mgt.api.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;
    @Override
    public void registerDrone(DroneDto droneDto) {

        if (droneRepository.existsBySerialNo(droneDto.getSerialNo())) {
            throw new ValidationException("serialNo");
        }
        Drone drone = DroneConverter.convert(droneDto);
        droneRepository.save(drone);
    }

    @Override
    public DroneDto getDrone(Long droneId) {

        Optional<Drone> droneOptional = droneRepository.findById(droneId);
        droneOptional.orElseThrow(() -> new RuntimeException("Drone Not  Found"));
        DroneDto drone = DroneConverter.convert(droneOptional.get());
        return drone;
    }
}
