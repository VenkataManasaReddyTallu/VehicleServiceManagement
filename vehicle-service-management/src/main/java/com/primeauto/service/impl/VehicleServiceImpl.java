package com.primeauto.service.impl;

import com.primeauto.entity.Customer;
import com.primeauto.entity.Vehicle;
import com.primeauto.repository.CustomerRepository;
import com.primeauto.repository.VehicleRepository;
import com.primeauto.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        if (vehicle.getCustomer() != null && vehicle.getCustomer().getId() != null) {
            Customer customer = customerRepository.findById(vehicle.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + vehicle.getCustomer().getId()));
            vehicle.setCustomer(customer); // Set the full customer object
        }
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
