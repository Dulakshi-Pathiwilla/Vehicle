package com.example.VehicleService.Repository;

import com.example.VehicleService.Entity.Vehicle;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByServiceYear(int serviceYear);

    @Query("SELECT v.vehicleType FROM Vehicle v WHERE v.serviceId = :serviceId")
    String findByServiceId(@Param("serviceId") Long serviceId);

    @Transactional
    @Modifying
    @Query("DELETE from Vehicle v WHERE v.serviceYear = :serviceYear")
    void deleteByServiceYear(@Param("serviceYear")int serviceYear);
}

