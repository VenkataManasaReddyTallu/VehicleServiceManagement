package com.primeauto.service.impl;

import com.primeauto.entity.ServiceRecord;
import com.primeauto.entity.ServiceRepresentative;
import com.primeauto.entity.Vehicle;
import com.primeauto.repository.ServiceRecordRepository;
import com.primeauto.repository.ServiceRepresentativeRepository;
import com.primeauto.repository.VehicleRepository;
import com.primeauto.service.ServiceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRecordServiceImpl implements ServiceRecordService {

    @Autowired
    private ServiceRecordRepository recordRepository;

    @Autowired
    private ServiceRepresentativeRepository representativeRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public ServiceRecord scheduleService(ServiceRecord record) {
        // Fetch and set managed vehicle entity
        if (record.getVehicle() != null && record.getVehicle().getId() != null) {
            Vehicle vehicle = vehicleRepository.findById(record.getVehicle().getId())
                    .orElseThrow(() -> new RuntimeException("Vehicle not found with ID: " + record.getVehicle().getId()));
            record.setVehicle(vehicle);
        }

        // Fetch and set managed service advisor entity
        if (record.getServiceAdvisor() != null && record.getServiceAdvisor().getId() != null) {
            ServiceRepresentative advisor = representativeRepository.findById(record.getServiceAdvisor().getId())
                    .orElseThrow(() -> new RuntimeException("Service Advisor not found with ID: " + record.getServiceAdvisor().getId()));
            record.setServiceAdvisor(advisor);
        }

        return recordRepository.save(record);
    }

    @Override
    public List<ServiceRecord> getAllRecords() {
        return recordRepository.findAll();
    }

    @Override
    public ServiceRecord getRecordById(Long id) {
        return recordRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }

    @Override
    public List<ServiceRecord> getByStatus(String status) {
        return recordRepository.findByStatus(status);
    }
}
