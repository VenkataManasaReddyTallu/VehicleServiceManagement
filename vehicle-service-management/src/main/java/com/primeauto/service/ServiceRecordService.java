package com.primeauto.service;

import com.primeauto.entity.ServiceRecord;

import java.util.List;

public interface ServiceRecordService {
    ServiceRecord scheduleService(ServiceRecord record);
    List<ServiceRecord> getAllRecords();
    ServiceRecord getRecordById(Long id);
    void deleteRecord(Long id);
    List<ServiceRecord> getByStatus(String status);
}
