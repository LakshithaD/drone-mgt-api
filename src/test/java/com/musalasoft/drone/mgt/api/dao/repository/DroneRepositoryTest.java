package com.musalasoft.drone.mgt.api.dao.repository;

import com.musalasoft.drone.mgt.api.dao.entity.Drone;
import com.musalasoft.drone.mgt.api.enums.DroneModel;
import com.musalasoft.drone.mgt.api.enums.DroneState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DroneRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DroneRepository droneRepository;

    @Test
    void findByStateIn() {

        // given
        Drone loadedDrone = new Drone();
        loadedDrone.setBatteryCapacity(12f);
        loadedDrone.setState(DroneState.LOADED);
        loadedDrone.setModel(DroneModel.CRUISE_WEIGHT);
        loadedDrone.setSerialNo("0111011");
        loadedDrone.setWeightLimit(400f);
        entityManager.persist(loadedDrone);

        Drone deliveringDrone = new Drone();
        deliveringDrone.setBatteryCapacity(12f);
        deliveringDrone.setState(DroneState.DELIVERING);
        deliveringDrone.setModel(DroneModel.CRUISE_WEIGHT);
        deliveringDrone.setSerialNo("0111012");
        deliveringDrone.setWeightLimit(400f);
        entityManager.persist(deliveringDrone);
        entityManager.flush();

        // when
        List<Drone> found = droneRepository.findByStateIn(List.of(DroneState.LOADED));

        // then
        assertThat(found.size())
                .isEqualTo(1);
    }
}