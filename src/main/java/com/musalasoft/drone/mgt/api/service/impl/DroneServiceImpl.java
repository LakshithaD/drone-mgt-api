package com.musalasoft.drone.mgt.api.service.impl;

import com.musalasoft.drone.mgt.api.FileUtil;
import com.musalasoft.drone.mgt.api.dao.entity.Drone;
import com.musalasoft.drone.mgt.api.dao.entity.Medication;
import com.musalasoft.drone.mgt.api.dao.repository.DroneRepository;
import com.musalasoft.drone.mgt.api.dao.repository.MedicationRepository;
import com.musalasoft.drone.mgt.api.dto.DroneDto;
import com.musalasoft.drone.mgt.api.dto.MedicationDto;
import com.musalasoft.drone.mgt.api.enums.DroneState;
import com.musalasoft.drone.mgt.api.excetions.BusinessException;
import com.musalasoft.drone.mgt.api.excetions.ResourceNotFoundException;
import com.musalasoft.drone.mgt.api.excetions.ValidationException;
import com.musalasoft.drone.mgt.api.service.DroneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;
    private final MedicationRepository medicationRepository;
    @Override
    public void registerDrone(DroneDto droneDto) {

        log.debug("checking drone exists for the given serial no");
        if (droneRepository.existsBySerialNo(droneDto.getSerialNo())) {
            throw new ValidationException("serialNo");
        }
        log.debug("converting to drone entity");
        Drone drone = DroneConverter.convert(droneDto);
        log.debug("saving the drone entity");
        droneRepository.save(drone);
        log.debug("saved the drone in database");
    }

    @Override
    public void loadDroneWithMedicationItems(Long droneId, List<MedicationDto> medications, MultipartFile[] images) {

        //Validations
        log.debug("Checking the drone exists");
        Optional<Drone> droneOptional = droneRepository.findById(droneId);
        droneOptional.orElseThrow(() -> new ResourceNotFoundException("Drone not found", droneId.toString()));
        Drone drone = droneOptional.get();
        log.debug("Checking the drone is ready to be loaded");
        if (drone.getState() == DroneState.LOADED || drone.getState() == DroneState.DELIVERING) {
            throw new BusinessException("Drone is not ready to be loaded");
        }
        log.debug("Checking the medication weights with the drone capacity");
        Float loadedWeight = drone.getMedications().stream()
                .map(Medication::getWeight)
                .reduce((weightOne, weightTwo) -> weightOne + weightTwo).get();
        Float weightToBeLoaded = medications.stream()
                .map(MedicationDto::getWeight)
                .reduce((weightOne, weightTwo) -> weightOne + weightTwo).get();
        if (loadedWeight + weightToBeLoaded > drone.getWeightLimit()) {
            throw new BusinessException("Drone will be overloaded with medications");
        }
        if (images.length != medications.size()) {
            throw new BusinessException("Medications count and image count mismatch");
        }

        //implementation
        log.debug("converting to medication entities");
        List<Medication> medicationsList = medications
                .stream()
                .map(medicationDto -> MedicationConverter.convert(medicationDto, drone))
                .collect(Collectors.toList());

        log.debug("saving the medication image in file path and setting the image path in entity");
        for (int i = 0; i < images.length ; i++) {
            String imagePath = FileUtil.storeFile(images[i]);
            medicationsList.get(i).setImagePath(imagePath);
        }
        log.debug("persisting drone medications");
        medicationRepository.saveAll(medicationsList);
        log.debug("done drone medication loading");
    }

    @Override
    public DroneDto getDrone(Long droneId) {

        Optional<Drone> droneOptional = droneRepository.findById(droneId);
        droneOptional.orElseThrow(() -> new ResourceNotFoundException("Drone not found", droneId.toString()));
        DroneDto drone = DroneConverter.convert(droneOptional.get());
        return drone;
    }

    @Override
    public List<MedicationDto> getDroneLoadedMedicationItems(Long droneId) {

        Optional<Drone> droneOptional = droneRepository.findById(droneId);
        droneOptional.orElseThrow(() -> new RuntimeException("Drone Not  Found"));
        List<Medication> medications = medicationRepository.findByDroneId(droneId);
        return medications.stream()
                .map(MedicationConverter::convert)
                .collect(Collectors.toList());
    }
}
