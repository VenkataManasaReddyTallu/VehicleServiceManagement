package com.primeauto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primeauto.entity.Vehicle;

public interface VehicleRepository  extends JpaRepository<Vehicle, Long> {

}
