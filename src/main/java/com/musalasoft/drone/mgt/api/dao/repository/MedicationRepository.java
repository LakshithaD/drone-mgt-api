package com.musalasoft.drone.mgt.api.dao.repository;

import com.musalasoft.drone.mgt.api.dao.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

    @Query("select m from Medication m where m.drone.id = :droneId")
    List<Medication> findByDroneId(@Param("droneId") Long droneId);
}
